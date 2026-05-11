# FastLane Setup for No Thanks! Android App

This project is configured with FastLane for automated deployment to the Google Play Store.

## Setup Instructions

### 1. Install Ruby and FastLane
```bash
# Install Ruby (if not already installed)
# On macOS: brew install ruby
# On Windows: Download from rubyinstaller.org

# Install Bundler
gem install bundler

# Install FastLane dependencies
bundle install
```

### 2. Configure Environment Variables
1. Copy `.env.example` to `.env`
2. Fill in your actual values:
   - `KEYSTORE_PASSWORD`: Your release keystore password
   - `KEY_ALIAS`: Your key alias
   - `KEY_PASSWORD`: Your key password

### 3. Google Play Store Setup
1. Create a Google Play Service Account
2. Download the JSON key file
3. Place it at `fastlane/google-play-service-account.json`
4. Uncomment and update the `json_key` line in `fastlane/Supplyfile`

### 4. Keystore Setup
1. Create a release keystore or use existing one
2. Place it in a `keystore/` directory (recommended)
3. Update the paths in the Fastfile if necessary

## Available Lanes

### Development
- `fastlane test` - Run all tests
- `fastlane build_debug` - Build debug APK
- `fastlane clean` - Clean the project

### Deployment
- `fastlane build_release` - Build release APK
- `fastlane deploy` - Build and deploy to Google Play Store (internal track)
- `fastlane upload_metadata` - Upload metadata only
- `fastlane upload_screenshots` - Upload screenshots only

## Directory Structure
```
fastlane/
├── Fastfile              # Lane definitions
├── Supplyfile            # Supply configuration
├── .gitignore           # FastLane specific ignores
└── metadata/             # Play Store metadata
    └── en-US/           # English (US) locale
        ├── title.txt
        ├── short_description.txt
        ├── full_description.txt
        ├── release_notes.txt
        └── images/       # Store listing images
```

## Usage Examples

### Deploy a new version
```bash
fastlane deploy
```

### Update metadata only
```bash
fastlane upload_metadata
```

### Upload new screenshots
```bash
# Add screenshots to fastlane/metadata/en-US/images/phoneScreenshots/
fastlane upload_screenshots
```

## Troubleshooting

### Common Issues
1. **Missing Ruby gems**: Run `bundle install`
2. **Authentication errors**: Check your Google Play Service Account setup
3. **Keystore issues**: Verify keystore paths and passwords in `.env`
4. **Metadata validation**: Ensure text files don't exceed character limits

### Debug Mode
Add `--verbose` flag for detailed output:
```bash
fastlane deploy --verbose
```

## Resources
- [FastLane Documentation](https://docs.fastlane.tools/)
- [FastLane Supply Action](https://docs.fastlane.tools/actions/supply/)
- [Google Play Console API Access](https://developers.google.com/android-publisher/getting_started)
