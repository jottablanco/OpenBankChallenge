OpenBank Challenge: Marvel Characters App.

--------
Summary:
--------
App that fetches the list of Marvel Characters using their API. 
This project was created using Android Studio Bumblebee | 2021.1.1.

--------
Details:
--------

The app uses the following components

- MVVM Architecture : Jetpack
- Persistence: Android Room
- Networking: Okhttp (HTTP Client) + Retrofit (REST Abstraction)
- Dependency Injection: Hilt
- ViewBinding: Instance of a generated XML layout to avoid views boilerplate code
- Repository Pattern: Single source of truth for app's data (retrieve from API, store in database)
- LiveData: Cycle aware observable to manage data coming from repositories 
- SplashScreen Android Component: simple android component to create an animated splash screen
- Navigation Component: Make navigation between fragments easily by using a nav_graph 

Note: The challenge asks to use the API to fetch the character details but it seems more practical to pass the details in a bundle that 
repeats the logic of fetching data from an API (used to get the characters list). Instead I passed the data to avoid unnecessary calls to 
the API and added favorites capability. A soul for a soul! wink wink ;)


For more details on the purpose of this feature, its limitations and detailed usage,
please read the SDK guide at
http://developer.android.com

DISCLAIMER: Images, names, and all data displayed in this App is provided by Marvel. All Right Reserved.  
