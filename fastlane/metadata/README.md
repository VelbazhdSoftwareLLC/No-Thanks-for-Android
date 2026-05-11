# FastLane Metadata

This directory contains metadata for the Google Play Store listing, managed by FastLane.

## Directory Structure

```
metadata/
├── en-US/                          # English (US) locale
│   ├── title.txt                  # App title (30 chars max)
│   ├── short_description.txt       # Short description (80 chars max)
│   ├── full_description.txt        # Full description (4000 chars max)
│   ├── release_notes.txt          # Release notes for updates
│   └── images/                     # Store listing images
│       ├── featureGraphic/         # Feature graphic (1024x500px)
│       ├── icon/                   # App icon (512x512px)
│       ├── phoneScreenshots/       # Phone screenshots (320-3840px)
│       ├── sevenInchScreenshots/   # 7" tablet screenshots (320-3840px)
│       ├── tenInchScreenshots/     # 10" tablet screenshots (320-3840px)
│       ├── tvScreenshots/          # Android TV screenshots (320-3840px)
│       └── wearScreenshots/        # Wear OS screenshots (320-3840px)
```

## Image Requirements

### Feature Graphic
- **Size**: 1024x500 pixels
- **Format**: PNG or JPEG
- **Purpose**: Featured in store listings and promotions

### App Icon
- **Size**: 512x512 pixels
- **Format**: PNG (no transparency)
- **Purpose**: Main app icon in Play Store

### Screenshots
- **Phone**: 320-3840px (minimum 320px, maximum 3840px)
- **Tablet**: 320-3840px (minimum 320px, maximum 3840px)
- **TV**: 320-3840px (minimum 320px, maximum 3840px)
- **Wear**: 320-3840px (minimum 320px, maximum 3840px)
- **Format**: PNG or JPEG
- **Maximum**: 8 screenshots per device type

## Text Content Limits

- **Title**: Maximum 30 characters
- **Short Description**: Maximum 80 characters
- **Full Description**: Maximum 4000 characters
- **Release Notes**: Maximum 500 characters per release

## Usage

FastLane will automatically use this metadata when uploading to the Google Play Store. To update store listing:

1. Modify the appropriate text files
2. Add/update images in the correct directories
3. Run `fastlane supply` to upload changes

## Adding New Languages

To add support for additional languages, create a new directory with the appropriate locale code (e.g., `es-ES`, `fr-FR`, `de-DE`) and copy the structure from `en-US/`.
