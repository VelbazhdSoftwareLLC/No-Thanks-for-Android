# Image Creation Guide for No Thanks! FastLane Metadata

This guide explains how to create the proper images for the Google Play Store listing.

## Current Status
✅ Directory structure created
⚠️  Placeholder files created (need to be replaced with actual images)

## Image Requirements

### 1. Feature Graphic (`featureGraphic/feature-graphic.png`)
- **Size**: 1024x500 pixels
- **Format**: PNG or JPEG
- **Purpose**: Featured in store listings and promotions
- **Design Suggestions**:
  - Include "No Thanks!" logo prominently
  - Show card game elements (cards, chips)
  - Use vibrant, eye-catching colors
  - Add tagline: "Popular Card Game"
  - Clean, professional design

### 2. App Icon (`icon/icon-512.png`)
- **Size**: 512x512 pixels
- **Format**: PNG (no transparency)
- **Purpose**: Main app icon in Play Store
- **Design Suggestions**:
  - High-quality card game icon
  - Clear and recognizable at small sizes
  - Use game-appropriate colors (reds, blacks, whites)
  - Modern, professional appearance

### 3. Phone Screenshots (`phoneScreenshots/`)
- **Size**: 320-3840px (recommended: 1080x1920px)
- **Format**: PNG or JPEG
- **Maximum**: 8 screenshots
- **Required Shots**:
  1. **Main Menu**: Title screen with play button
  2. **Gameplay**: Cards and chips in action
  3. **Player Turn**: Decision-making interface
  4. **Multiplayer**: Multiple players visible
  5. **Scoring**: End game results
  6. **Settings**: Options and preferences

### 4. Tablet Screenshots (`sevenInchScreenshots/`, `tenInchScreenshots/`)
- **Size**: 320-3840px (recommended: 1200x1920px for 7", 1600x2560px for 10")
- **Format**: PNG or JPEG
- **Purpose**: Show optimized tablet interface
- **Design**: Enhanced UI with larger elements

### 5. TV Screenshots (`tvScreenshots/`)
- **Size**: 320-3840px (recommended: 1920x1080px)
- **Format**: PNG or JPEG
- **Purpose**: Android TV compatibility
- **Design**: Large text, simplified controls

### 6. Wear OS Screenshots (`wearScreenshots/`)
- **Size**: 320-3840px (recommended: 320x320px)
- **Format**: PNG or JPEG
- **Purpose**: Smartwatch compatibility
- **Design**: Minimal, essential controls only

## How to Create Screenshots

### Using Android Studio
1. Run the app in emulator
2. Use **Screenshot** tool (View → Tool Windows → Screenshots)
3. Capture screenshots for each device type
4. Save to appropriate directories

### Using ADB Commands
```bash
# Take screenshot
adb shell screencap -p /sdcard/screenshot.png
# Pull to computer
adb pull /sdcard/screenshot.png
```

### Design Tools
- **Adobe Photoshop** or **GIMP** for feature graphic
- **Canva** for quick designs
- **Figma** for mockups

## Naming Conventions
- Feature graphic: `feature-graphic.png`
- App icon: `icon-512.png`
- Screenshots: `screenshot-1.png`, `screenshot-2.png`, etc.

## Validation
Before uploading:
1. Check image dimensions
2. Verify file formats
3. Ensure no system UI elements in screenshots
4. Test visibility at different sizes
5. Follow Google Play Store guidelines

## Next Steps
1. Replace all placeholder files with actual images
2. Test FastLane upload: `fastlane upload_screenshots`
3. Verify in Google Play Console

## Resources
- [Google Play Store Image Guidelines](https://support.google.com/googleplay/android-developer/answer/1078870)
- [FastLane Supply Documentation](https://docs.fastlane.tools/actions/supply/)
