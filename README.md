# Firebase Photo Gallery App

A modern Android application that allows users to upload and view photos using Firebase Storage and Realtime Database. The app provides a simple interface for image management with cloud storage capabilities.

## 📱 Features

- **Image Upload**: Select and upload images from device gallery to Firebase Storage
- **Cloud Storage**: Secure image storage using Firebase Storage
- **Gallery View**: Display uploaded images in a responsive grid layout
- **Real-time Updates**: Automatic synchronization with Firebase Realtime Database
- **Progress Tracking**: Visual progress indicator during upload process
- **Modern UI**: Clean and intuitive user interface with Material Design

## 🛠️ Technical Stack

- **Platform**: Android (API 27+)
- **Language**: Java
- **Backend**: Firebase
  - Firebase Storage (for image files)
  - Firebase Realtime Database (for metadata)
- **Image Loading**: Glide library for efficient image caching
- **UI Framework**: Android Views with CardView components

## 📋 Prerequisites

- Android Studio (latest version)
- Firebase project setup
- Android device/emulator with API level 27 or higher
- Google Services configuration

## 🚀 Installation & Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
cd Midterm
```

### 2. Firebase Configuration

1. Create a new Firebase project at [Firebase Console](https://console.firebase.google.com/)
2. Enable Firebase Storage and Realtime Database
3. Download `google-services.json` and place it in the `app/` directory
4. Configure Firebase Storage rules for your project

### 3. Build and Run

1. Open the project in Android Studio
2. Sync the project with Gradle files
3. Run the app on your device or emulator

## 📁 Project Structure

```
app/
├── src/main/
│   ├── java/hcmute/edu/vn/firebase/
│   │   ├── MainActivity.java          # Main upload activity
│   │   ├── ShowActivity.java          # Gallery display activity
│   │   ├── Model_Image.java           # Data model for images
│   │   └── MyAdapter.java             # GridView adapter for image display
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml      # Main activity layout
│   │   │   ├── activity_show.xml      # Gallery layout
│   │   │   └── grid_item.xml          # Grid item layout
│   │   └── values/
│   │       └── strings.xml            # App strings
│   └── AndroidManifest.xml            # App configuration
├── google-services.json               # Firebase configuration
└── build.gradle.kts                   # App dependencies
```

## 🔧 Key Components

### MainActivity

- Handles image selection from gallery
- Manages Firebase Storage upload process
- Provides navigation to gallery view
- Shows upload progress and status

### ShowActivity

- Displays uploaded images in a 3-column grid
- Real-time updates from Firebase Database
- Efficient image loading with Glide

### Model_Image

- Data model representing image metadata
- Stores Firebase Storage URLs
- Serializable for database operations

### MyAdapter

- Custom BaseAdapter for GridView
- Asynchronous image loading
- ViewHolder pattern for performance
- Background thread execution for image processing

## 🎨 User Interface

- **Main Screen**: Image preview area with upload and gallery buttons
- **Gallery Screen**: 3-column grid layout with card-based image display
- **Progress Indicator**: Horizontal progress bar during uploads
- **Material Design**: CardView components with elevation and rounded corners

## 🔐 Firebase Configuration

### Storage Rules

```javascript
rules_version = '2';
service firebase.storage {
  match /b/{bucket}/o {
    match /{allPaths=**} {
      allow read, write: if request.auth != null;
    }
  }
}
```

### Database Rules

```json
{
  "rules": {
    "Image": {
      ".read": true,
      ".write": true
    }
  }
}
```

## 📱 Usage

1. **Upload Images**:

   - Tap the image preview area to select a photo
   - Click "Upload" to upload to Firebase Storage
   - Monitor progress with the progress bar

2. **View Gallery**:
   - Click "Show All" to view uploaded images
   - Images are displayed in a responsive grid
   - Real-time updates when new images are added

## 🚀 Dependencies

- `androidx.appcompat:appcompat:1.6.1`
- `com.google.android.material:material:1.11.0`
- `androidx.constraintlayout:constraintlayout:2.1.4`
- `com.google.firebase:firebase-database:20.3.1`
- `com.google.firebase:firebase-storage:20.3.0`
- `com.github.bumptech.glide:glide:4.16.0`

## 🔧 Configuration

### Build Configuration

- **Min SDK**: 27 (Android 8.1)
- **Target SDK**: 34 (Android 14)
- **Compile SDK**: 34
- **Java Version**: 1.8

### Permissions

The app requires the following permissions (automatically handled):

- Internet access for Firebase communication
- Storage access for image selection

## 🐛 Troubleshooting

### Common Issues

1. **Upload Failures**: Check Firebase Storage rules and internet connection
2. **Image Loading Issues**: Verify Firebase Storage URLs and Glide configuration
3. **Build Errors**: Ensure `google-services.json` is properly placed

### Debug Steps

1. Check Firebase Console for upload errors
2. Verify database rules allow read/write access
3. Test with different image formats and sizes

## 📄 License

This project is developed for educational purposes as part of a midterm assignment.

## 👨‍💻 Developer

Developed by HCMUTE (Ho Chi Minh City University of Technology and Education) - Firebase course project.

---

**Note**: This application requires proper Firebase project setup and configuration to function correctly. Ensure all Firebase services are properly configured before running the application.
