# The Shoe Store

This project is part of the <a href="https://www.udacity.com/course/android-kotlin-developer-nanodegree--nd940">Udacity Nanodegree Program</a>

It consists of five screens:
1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Shoe Listing screen
5. Shoe Detail screen for adding a new shoe

Project rubric can be found <a href="https://review.udacity.com/#!/rubrics/2849/view">here</a>

<table style="width:100%">
  <tr>
    <td><img src="https://user-images.githubusercontent.com/15269393/129074746-56cab240-e82c-4167-9ac6-a6dd385ecbf9.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/129074768-ee27e4e0-3e9d-40b1-9751-ec7d62ae322f.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/129074767-3207aa20-d74c-4054-9f6e-e340721e2bbf.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/129074765-a1590677-f7fd-447c-9c49-8bfab3898002.jpg"></td>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/15269393/129074764-484d6341-1f54-4e63-8219-98469ccd1123.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/129074758-e75edc28-37db-4a4e-9c28-c4bfb19a6c08.jpg"></td>
    <td><img src="https://user-images.githubusercontent.com/15269393/129074751-c242194a-8df0-4a97-9697-94fa34d85065.jpg"></td>
  </tr>
</table>

## Steps

1. Open the starter project in Android Studio

2. Add the navigation libraries to the app build.gradle file

3. Add the safe-arg plugin to the main and app build.gradle file

4. Create a new navigation xml file

5. Create a new Login destination.

   * Include email and password labels 

   - Include email and password fields
   - Create buttons for creating a new login and logging in with an existing account
   - Clicking either button should navigate to the Welcome Screen.

6. Create a new Welcome screen destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the instructions screen

7. Create a new Instruction destination that includes:

   * A new layout
   * At least 2 textviews
   * A navigation button with actions to navigate to the shoe list screen

8. Create a class that extends ViewModel

   *  Use a LiveData field that returns the list of shoes

9. Create a new Shoe List destination that includes:

   * A new layout
   * A ScrollView
   * A LinearLayout for Shoe Items
   * A FloatingActionButton with an action to navigate to the shoe detail screen
   * A Logout overflow menu, which returns user to the home screen

10. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

11. Create a new Shoe Detail destination that includes:

    * A new layout
    * A TextView label and EditView for the
      * Shoe Name
      * Company
      * Shoe Size
      * Description
    * A Cancel button with an action to navigate back to the shoe list screen
    * A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model

12. Make sure you can’t go back to onboarding screens

13. In the Shoe List screen:

    * Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
    * Observe the shoes variable from the ViewModel
    * Use DataBindingUtil to inflate the shoe_list layout
    * Add a new layout item into the scrollview for each shoe.
