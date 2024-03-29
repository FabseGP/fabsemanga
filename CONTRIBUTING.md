Looking to report an issue/bug or make a feature request? Please refer to the [README file](https://codeberg.org/fabseman/fabsemanga#issues-feature-requests-and-contributing).

---

Thanks for your interest in contributing to Fabsemanga!


# Code contributions

Pull requests are welcome!

If you're interested in taking on [an open issue](https://codeberg.org/fabseman/fabsemanga/issues), please comment on it so others are aware.
You do not need to ask for permission nor an assignment.

## Prerequisites

Before you start, please note that the ability to use following technologies is **required** and that existing contributors will not actively teach them to you.

- Basic [Android development](https://developer.android.com/)
- [Kotlin](https://kotlinlang.org/)

### Tools

- [Android Studio](https://developer.android.com/studio)
- Emulator or phone with developer options enabled to test changes.

## Linting

To auto-fix some linting errors, run the `ktlintFormat` Gradle task.

## Getting help

- Ask in [issues](https://codeberg.org/fabseman/fabsemanga/issues) with **HELP NEEDED** as the title.

# Translations

Translations soon to be implemented using weblate.


# Forks

Forks are allowed so long as they abide by [the project's LICENSE](https://codeberg.org/fabseman/fabsemanga/src/branch/master/LICENSE).

When creating a fork, remember to:

- To avoid confusion with the main app:
    - Change the app name
    - Change the app icon
    - Change or disable the [app update checker](https://codeberg.org/fabseman/fabsemanga/src/branch/master/app/src/main/java/eu/kanade/tachiyomi/data/updater/AppUpdateChecker.kt)
- To avoid installation conflicts:
    - Change the `applicationId` in [`build.gradle.kts`](https://codeberg.org/fabseman/fabsemanga/src/branch/master/app/build.gradle.kts)
