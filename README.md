# Site Management App

<p align="center">
  <img src="ass2/app/src/main/ass2_logo-playstore.png" alt="Site Management App logo" width="160" />
</p>

<p align="center">
  An Android application for discovering, creating, and managing sites directly on a map.
</p>

<p align="center">
  <img alt="Android" src="https://img.shields.io/badge/Android-21%2B-3DDC84?logo=android&logoColor=white" />
  <img alt="Java" src="https://img.shields.io/badge/Java-8-ED8B00?logo=openjdk&logoColor=white" />
  <img alt="Google Maps" src="https://img.shields.io/badge/Google_Maps-SDK-4285F4?logo=googlemaps&logoColor=white" />
  <img alt="SQLite" src="https://img.shields.io/badge/SQLite-Local_database-003B57?logo=sqlite&logoColor=white" />
</p>

## Overview

Site Management App is an Android project that connects users with sites displayed on a map. Users can create an account, search for locations, view their current position, launch Google Maps navigation, and register to join a site. Site owners can monitor their member list, while administrators can add, view, and remove sites.

## Key Features

### Users

- Create an account and sign in.
- Choose between user and site-owner modes.
- View available sites as markers on Google Maps.
- Search for an address and move the map to the result.
- View the device's current location.
- Select a point on the map to create a new site.
- View site information and launch directions in Google Maps.
- Submit a form to join a site.

### Site Owners

- View the list of users who have joined a site.
- Access member names and phone numbers.

### Administrators

- View the complete site list.
- Add a site with its name, owner, location, and capacity.
- Delete site data.

## App Interface

<p align="center">
  <img src="ass2/app/src/main/ass2_logo-playstore.png" alt="Site Management App logo" width="240" />
</p>

> The repository does not currently contain application screenshots. Add screenshots to `docs/screenshots/`, then replace this section with a showcase table such as:
>
> | Welcome | Sign In | Map |
> | --- | --- | --- |
> | `docs/screenshots/welcome.png` | `docs/screenshots/login.png` | `docs/screenshots/map.png` |

## Tech Stack

- Java 8
- Android SDK 34 (minimum SDK 21)
- AndroidX AppCompat, ConstraintLayout, and RecyclerView
- Material Components
- Google Maps SDK for Android
- Google Play Services Location
- SQLite for storing accounts, sites, and members locally
- REST API and JSON for retrieving and submitting site data

## Project Structure

```text
android-asm2-project/
└── ass2/
    ├── app/
    │   └── src/main/
    │       ├── java/com/example/ass2/  # Activities, models, adapters, database
    │       ├── res/layout/              # XML user interfaces
    │       ├── res/drawable/            # Background images and icons
    │       └── AndroidManifest.xml
    ├── build.gradle.kts
    └── settings.gradle.kts
```

## Installation

### Requirements

- A recent Android Studio version with Android SDK 34 support
- A JDK version compatible with the project's Android Gradle Plugin
- A physical device or Android emulator running Android 5.0 (API 21) or later
- A Google Maps API key with **Maps SDK for Android** enabled

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/ltdin/android-asm2-project.git
   cd android-asm2-project/ass2
   ```

2. Open the `ass2` directory in Android Studio and wait for Gradle synchronization to complete.

3. Create `local.properties` inside the `ass2` directory if it does not exist, then add your API key:

   ```properties
   MAPS_API_KEY=YOUR_GOOGLE_MAPS_API_KEY
   ```

4. In `AndroidManifest.xml`, reference the configuration variable instead of placing the key directly in source code:

   ```xml
   <meta-data
       android:name="com.google.android.geo.API_KEY"
       android:value="${MAPS_API_KEY}" />
   ```

5. Update `SITE_API_URL` in `MapsActivity.java` with the URL of an active API server.

6. Install the debug build:

   ```bash
   ./gradlew installDebug
   ```

   Alternatively, select a device in Android Studio and click **Run**.

## User Flow

```text
Welcome screen
├── Sign up → Sign in
└── Sign in
    ├── Administrator → Manage sites
    └── Regular user → Choose a role
        ├── User → Map → View/Create/Join a site
        └── Site owner → View member list
```

## Configuration and Security Notes

- Do not commit a Google Maps API key to source control. Restrict the key by package name and SHA-1 fingerprint in Google Cloud Console.
- The ngrok URL in the source code is temporary and may no longer be active. Replace it with a working backend URL.
- Accounts and passwords are currently stored locally in SQLite. A production application should encrypt sensitive data and use backend authentication.
- Administrator credentials should not be hard-coded in a production build.

## Future Improvements

- Synchronize users, sites, and members with a backend service.
- Add token-based authentication and role authorization.
- Allow individual sites and members to be edited.
- Improve input validation and network-state handling.
- Add application screenshots, UI tests, and a CI/CD pipeline.

## Author

Source code: [ltdin/android-asm2-project](https://github.com/ltdin/android-asm2-project)

## License

This repository does not currently declare a license. Contact the author before copying, modifying, or distributing the project.
                
