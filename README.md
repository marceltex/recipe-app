# Android Coding Exercise Solution - Recipe App:

## Part A - Fix current bugs

### Bug 1 - Layout does not look as expected

The constraints were broken/non-existant for many views on the login screen, which was causing it to not look like the design. To fix this I did the following:

- Constrained the top of the password til to the bottom of the email til (text input layout)
- Constrained the top of the name til to the bottom of the password til
- Added horizontal constraints for all the tils and gave them a margin of 16dp on both the start and end to add some padding
- Added horizontal constraints for the animation view
- Added horizontal constraints for the sign in button and constrained the top of the sign in button to the bottom of the animation

### Bug 2 - Validation is incorrect


To fix the incorrect validation, I did the following:

- First, I noticed that the validation on the name til was completely wrong. If the name was invalid, it was setting an error message on the `til_email`. I changed this so that the error is set on the `til_name` itself.
- I also noticed the `NAME_REGEX` was being compared to the text that had been entered in the `password_et` (edit text). I changed this so that the `NAME REGEX` is compared to the text in the `name_et`.
- Next I wrapped the name pattern checks in an `if (et_name.text.isNotEmpty())`. Since the name field is optional, I only want to do validation on it, if the user has entered some text in it.
- I noticed that the way the `allValid` Boolean was working, is that only one of the fields would need to be valid in order for it to be `true`, which is incorrect. I decided to flip the way the `allValid` Boolean works. I initialised it with a value of `true`, then if any validation failed on any of the fields, I set the allValid Boolean to `false`. This ensures that all the fields have to be valid for the all valid boolean to be returned as `true`.

### Bug 3 - Animation is looping incorrectly

To fix the animation looping incorrectly, I modified the `setupAnimation()` function in the `LoginActivity.kt` file, as shown below:

```kotlin
private fun setupAnimation() {
    pigAnimation.setMinAndMaxFrame(firstAnim.first, firstAnim.second)
    pigAnimation.playAnimation()

    pigAnimation.addAnimatorListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {
        }

        override fun onAnimationEnd(animation: Animator) {
            pigAnimation.setMinAndMaxFrame(secondAnim.first, secondAnim.second)
            pigAnimation.repeatCount = ValueAnimator.INFINITE
            pigAnimation.playAnimation()
        }

        override fun onAnimationCancel(animation: Animator) {
        }

        override fun onAnimationRepeat(animation: Animator) {
        }
    })
}
```

Before playing the animation for the first time, I changed the start and ending frames of the animation to the frame range that should only be played once. I then triggered the frst animation to play.
I added an `AnimationListener` to "observe" the animation and when it is finished, and the `onAnimationEnd` function is called, I set the start and ending frames of the animation to the frame range that should be looped continuously. I made the animation loop continuously by setting the `repeatCount` property of the animation to `ValueAnimator.INFINITE`.

## Part B - Add 2 new screens

We now want to give some useful functionality to our users. To allow them to log into the app, view and edit their account using our sandbox API.

### Screen 2 - User accounts screen
This screen should be shown after the user has successfully logged in and should show have the following functionality:
- Display "Hello {name} **only** if they provided it on previous screen"
- Show the **'TotalPlanValue'** of a user.
- Show the accounts the user holds, e.g. ISA, GIA, LISA, Pension.
- Show all of those account's **'PlanValue'**.
- Shhow all of those account's **'Moneybox'** total.

### Screen 3 - Individual account screen
If a user selects one of those accounts, they should then be taken to this screen.  This screen should have the following functionality:
- Show the **'Name'** of the account.
- Show the account's **'PlanValue'**.
- Show the accounts **'Moneybox'** total.
- Allow a user to add to a fixed value (e.g. £10) to their moneybox total.

A prototype wireframe of all 3 screens is provided as a guideline. You are free to change any elements of the screen and provide additional information if you wish.

![](/images/wireframe.png)

## What we are looking for:
 - An android application written in either Java or Kotlin.
 - Demonstration of coding style and design patterns.
 - Knowledge of common android libraries and any others that you find useful.
 - Storage of data between screens.
 - Consistency of data between screens.
 - Error handling.
 - Any form of unit or integration testing you see fit.
 - The application must run on Android 5.0 and above.
 - The application must compile and run in Android Studio.

Please feel free to refactor the LoginActivity and use any libraries/helper methods to make your life easier.

## How to Submit your solution:
 - Clone this repository
 - Create a public repo in github, bitbucket or a suitable alternative and provide a link to the repository.
 - Provide a readme in markdown which details how you solved the bugs in part A, and explains the structure of your solution in Part B and any libraries that you may have used.

## API Usage
This a brief summary of the api endpoints in the moneybox sandbox environment. There a lot of other additional properties from the json responses that are not relevant, but you must use these endpoints to retrieve the information needed for this application.

#### Base URL & Test User
The base URL for the moneybox sandbox environment is `https://api-test01.moneyboxapp.com/`.
You can log into test your app using the following user:

|  Username          | Password         |
| ------------- | ------------- |
| androidtest@moneyboxapp.com  | P455word12  |

#### Headers

In order to make requests https must be used and the following headers must be included in each request.

|  Key | Value |
| ------------- | ------------- |
| AppId  | 3a97b932a9d449c981b595  |
| Content-Type  | application/json  |
| appVersion | 5.10.0 |
| apiVersion | 3.0.0 |

#### Authentication
To login with this user to retrieve a bearer token you need to call `POST /users/login`.
```
POST /users/login
{
  "Email": "androidtest@moneyboxapp.com",
  "Password": "P455word12",
  "Idfa": "ANYTHING"
}
```
Sample json response
```
"Session": {
        "BearerToken": "TsMWRkbrcu3NGrpf84gi2+pg0iOMVymyKklmkY0oI84=",
        "ExternalSessionId": "4ff0eab7-7d3f-40c5-b87b-68d4a4961983", -- not used
        "SessionExternalId": "4ff0eab7-7d3f-40c5-b87b-68d4a4961983", -- not used
        "ExpiryInSeconds": 0 -- not used
    }
```
After obtaining a bearer token an Authorization header must be provided for all other endpoints along with the headers listed above (Note: The BearerToken has a sliding expiration of 5 mins).

|  Key          | Value         |
| ------------- | ------------- |
| Authorization  | Bearer TsMWRkbrcu3NGrpf84gi2+pg0iOMVymyKklmkY0oI84=  |

#### Investor Products
Provides product and account information for a user that will be needed for the two additional screens.
```
GET /investorproducts
```
### One off payments
Adds a one off amount to the users moneybox.
```
POST /oneoffpayments
{
  "Amount": 20,
  "InvestorProductId": 3230 ------> The InvestorProductId from /investorproducts endpoint
}
```
Good luck!
