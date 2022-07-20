# Exercise 1

To complete this exercise successfully, you need to do the following:
1. Clone the [android-exercises](https://github.com/WW-Digital/android-exercises) repo to your computer.
1. Import `WW-Exercise-01` project into Android Studio.
1. Read and implement the [User Stories](#user-stories) below.
1. Run the application in the Emulator or on an Android device.
1. Ensure the app displays correctly when the orientation changes.
1. Submit your completed updates to the android-exercises repo using a pull request.

You may implement any architecture or use any libraries you feel are necessary. We are looking to see what production quality code looks like to you. Please avoid using code generators like [http://androidstarters.com](http://androidstarters.com) as the team will not be able to evaluate your work.

**User Stories**
1. As a user, when I make a request to the endpoint, [https://www.weightwatchers.com/assets/cmx/us/messages/collections.json](https://www.weightwatchers.com/assets/cmx/us/messages/collections.json), then I would like to see an image and title of each object in the response.
1. As a user, when I click on an item, then I would like to see a snackbar showing the filter associated with the item.
1. As a user, when I rotate my device, I would like to maintain my state.
1. Implement tests for the code you wrote like 
   (/* i implemented tests for repository when getting the data also for ViewModel when getting the data */).

**Bonus Points**
* Support dark mode in your design.
  (/*when the app is in dark mode the screen is black before loading the images also will be white if the light mode is on*/). 
* Display an empty state view 
  (/*if the response is empty if the list is empty there will appear a text empty*/).
* Display an error message if the request fails.
  (/*if anything went wrong then there will appear an error dialog showing details about the error the and there will be a button retry when you click on it it will call the api again*/).

