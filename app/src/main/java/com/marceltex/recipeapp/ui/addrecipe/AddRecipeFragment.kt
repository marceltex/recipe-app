package com.marceltex.recipeapp.ui.addrecipe

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.marceltex.recipeapp.R
import com.marceltex.recipeapp.epoxymodel.RemovableImageColumnModel_
import com.marceltex.recipeapp.epoxymodel.addImageColumn
import com.marceltex.recipeapp.epoxymodel.removableImageColumn
import com.marceltex.recipeapp.setTextIfDifferent
import com.marceltex.recipeapp.ui.BaseFragment
import com.marceltex.recipeapp.ui.MainActivity
import kotlinx.android.synthetic.main.add_recipe_fragment.*
import pl.aprilapps.easyphotopicker.DefaultCallback
import pl.aprilapps.easyphotopicker.EasyImage
import pl.aprilapps.easyphotopicker.MediaFile
import pl.aprilapps.easyphotopicker.MediaSource
import java.io.File
import javax.inject.Inject

class AddRecipeFragment : BaseFragment() {

    private val viewModel: AddRecipeViewModel by fragmentViewModel()
    private val images = mutableMapOf<String, File>()

    @Inject
    lateinit var viewModelFactory: AddRecipeViewModel.Factory
    @Inject
    lateinit var easyImage: EasyImage
    @Inject
    lateinit var gson: Gson

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_recipe_fragment, container, false)
        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_recipe_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                if (areAllFieldsValid()) {
                    viewModel.saveRecipe()

                    // Remove focus on text fields and hide keyboard
                    val view = activity?.window?.currentFocus
                    val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
                    view?.clearFocus()

                    Toast.makeText(context, R.string.recipe_saved_successfully_toast, Toast.LENGTH_LONG).show()
                }
            }
            else -> (activity as MainActivity).navController.navigateUp()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleEditText.addTextChangedListener( object: TextWatcher {

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {
                viewModel.setTitle(s.toString())
            }
        })

        descriptionEditText.addTextChangedListener( object: TextWatcher {

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun afterTextChanged(s: Editable?) {
                viewModel.setDescription(s.toString())
            }
        })


        setupAddImagesRecyclerView()
    }

    private fun setupAddImagesRecyclerView() {
        addImagesRecyclerView.withModels {
            addImageColumn {
                id("add_image")
                clickListener { _ -> launchImageSelector() }
            }
            for ((name, file) in images) {
                removableImageColumn {
                    id(name)
                    image(file)
                    clickListener { model, _, _, _ -> removeImage(model) }
                }
            }
        }
    }

    override fun invalidate() = withState(viewModel) { state ->
        titleEditText.setTextIfDifferent(state.newTitle)
        descriptionEditText.setTextIfDifferent(state.newDescription)

        val type = object : TypeToken<Array<File>>() {}.type
        val recipeImages = gson.fromJson<Array<File>>(state.newImages, type) ?: arrayOf()

        if (recipeImages.size != images.size) {
            images.clear()
            recipeImages.forEach { file ->
                images[file.name] = file
            }
            addImagesRecyclerView.requestModelBuild()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        easyImage.handleActivityResult(requestCode, resultCode, data, requireActivity(), object : DefaultCallback() {

            override fun onMediaFilesPicked(imageFiles: Array<MediaFile>, source: MediaSource) {
                imageFiles.forEach { imageFile ->
                    val file = File(context!!.filesDir, imageFile.file.name)
                    context!!.openFileOutput(imageFile.file.name, Context.MODE_PRIVATE).use {
                        it.write(imageFile.file.readBytes())
                    }
                    images[file.name] = file
                }
                viewModel.setImages(images.values.toTypedArray())
                addImagesRecyclerView.requestModelBuild()
            }

            override fun onImagePickerError(error: Throwable, source: MediaSource) {
                error.printStackTrace()
            }

            override fun onCanceled(source: MediaSource) {

            }
        })
    }

    // Below is a lot of boilerplate code that was required for requesting permissions and field validation

    private fun launchImageSelector() {
        if (arePermissionsGranted()) {
            easyImage.openDocuments(this)
        } else {
            requestPermission()
        }
    }

    private fun removeImage(model: RemovableImageColumnModel_) {
        images.remove(model.image().name)
        viewModel.setImages(images.values.toTypedArray())
        addImagesRecyclerView.requestModelBuild()
    }

    private fun arePermissionsGranted() =
        checkSelfPermission(context!!, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun requestPermission() {
        if (!arePermissionsGranted()) {
            val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            requestPermissions(permissions, WRITE_EXTERNAL_STORAGE_REQUEST)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            WRITE_EXTERNAL_STORAGE_REQUEST -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    easyImage.openDocuments(this)
                } else {
                    val shouldShowRationale = shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)

                    if (shouldShowRationale) {
                        requestPermission()
                    } else {
                        goToSettings()
                    }
                }
            }
        }
    }

    private fun goToSettings() {
        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:${context?.packageName}")).apply {
            addCategory(Intent.CATEGORY_DEFAULT)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }.also { intent ->
            startActivity(intent)
        }
    }


    private fun areAllFieldsValid(): Boolean {
        var allValid = true

        if (titleEditText.text.isNotBlank()) {
            titleTextInputLayout.error = ""
        } else {
            titleTextInputLayout.error = getString(R.string.title_error)
            allValid = false
        }

        if (descriptionEditText.text.isNotBlank()) {
            descriptionTextInputLayout.error = ""
        } else {
            descriptionTextInputLayout.error = getString(R.string.description_error)
            allValid = false
        }

        return allValid
    }

    companion object {
        private const val WRITE_EXTERNAL_STORAGE_REQUEST = 123
    }
}
