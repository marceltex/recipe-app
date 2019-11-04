# Android Coding Exercise - Recipe App:

## Architectural pattern followed

I decided to follow the MvRx Android framework to build this app. This was recommended in the coding exercise document. Once I grasped the flow and the concepts introduced in MvRx, I found it to be a very cool framework to use to build apps. I especially liked some of the cool helper functions provided with MvRx like `execute` that can be called on an Observable and it manages the subscribing to and disposing of that observable for you, which is really cool.

I structured the app as two fragments (`RecipesFragment` & `AddRecipeFragment`) and two view models (`RecipesViewModel` & `AddRecipeViewModel`) that are both bound to the lifecycle of their respective fragments. I decided to use two `fragmentViewModel`s instead of one `activityViewModel`, because each fragment has quite a well defined purpose and there wasn't a need for sharing any data between the fragments. The `RecipesViewModel` handles the retrieval of all the recipes stored in the database and the `AddRecipeViewModel` handles adding a new recipe to the database.

## Frameworks used and brief motivation

### Android Navigation Component (Android Jetpack)

I decided to use the Android Navigation component for the navigation of this app. I prefer using the Navigation component, as it provides a really concise and easy way to navigate between fragemnts, without needing to use the Fragment Manager.

### Room (Android Jetpack)

I decided to use Room to creat a local database of the recipes saved to the app. This will allow the data to be persisted locally even after the app has been killed.

#### Database design

This app has a simple database design that comprises of a single table named `recipes`. This table has 4 fields namely, `id`, `title`, `description`, `images`. The properties of each recipe record in the table is stored in the appropriate field. I know storing a list of images in the `images` field doesn't follow database normalisation at all. It actually deosn't even conform to first normal form (1NF) which states that each field should contain a single value. 

I initially thought about having a separate `images` table, but then decided against it. The overhead of doing joins across two tables, didn't seem worth it, especially because images will never be queried independently of recipes.

### Dagger 2

I used Dagger 2 to handle dependency injection throughout the app. I injected frameworks like `Gson` and `EasyImage`, so that there aren't multiple instances of these created throughout the app.

### Dagger 2 - Asisted inject

I needed to use `AssistedInject` to inject the `RecipeRepository` as a constructor parameter in both the view models. `AssistedInject` allows you to specify which constructor parameters should not be injected by dagger, by annotating these paramneters with `@Assisted`

### EasyImage

I used `EasyImage` to handle the image selection from the device's storage. When an image is selected I save it in the app's internal storage and store the reference to the internally saved image in the database. This allows the app to still work and display the correct images even if the user removes the original images from his device's external storage.

### Epoxy

I used `Epoxy` for all the Recycler Views throughout the app. `Epoxy` made it very easy to create heterogenous Recycler Views without the need to create multiple complex Adapters.

### Gson

I used `Gson` when saving data to the database. `Gson` was used to serialise the list of images into a JSON string to be stored in the `images` field of the database. I then used `Gson` again to deserialise the JSON string to a list images when retrieving data from the database.

### Picasso

I used `Picasso` to simplify the setting loading and displaying of images.
