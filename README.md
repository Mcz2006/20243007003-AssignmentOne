# CampusLife — COMPX202/Y05853 Assignment One

A responsive Android companion app for University of Waikato students. It shows a
welcome banner and four topic areas — **Facilities, Events, Clubs, Support** — each
of which opens a detail screen populated from `arrays.xml`.

* Language: Java
* Minimum SDK: API 24 (Android 7.0 Nougat)
* Application name: `CampusLife` (package `com.example.assignmentone`)
* Build: Gradle 8.9 + Android Gradle Plugin 8.7.3, JDK 17, compileSdk 35

## How the brief maps to the project

| Part | What was required | Where it lives |
| --- | --- | --- |
| A | App created from an Empty Views Activity, Java, min API 24, pushed with Git | whole project (`app/`), `.gitignore` |
| B | Portrait UI matching Figure 1, responsive, no hard-coded sizes (40sp banner text only) | `res/layout/activity_main.xml`, `res/values/dimens.xml` |
| C | App named *CampusLife*, new launcher icon, green/light green colours, pressed button selector | `values/strings.xml`, `mipmap-*`, `values/colors.xml`, `drawable/btn_green_selector.xml` |
| D | Landscape layout with the four buttons side by side | `res/layout-land/activity_main.xml` |
| E | `onClick` events on all four ImageButtons with a Toast | `MainActivity.java`, `android:onClick` in both layouts |
| F | `DetailActivity` + layout matching Figure 5 | `DetailActivity.java`, `res/layout/activity_detail.xml` |
| G | Explicit `Intent` with a unique identifier | `MainActivity.openTopic()` → `DetailActivity.EXTRA_TOPIC_INDEX` |
| H | Detail screen populated from `arrays.xml`, no `if`/`switch` | `DetailActivity.populateFromArrays()`, `values/arrays.xml` |
| I | Structured, commented code | all Java and XML files |

## Layout approach (why it is responsive)

* The screen is a weighted vertical `LinearLayout`: banner ≈ 54%, button panel ≈ 46%.
* The 2 × 2 button grid is built from nested weighted `LinearLayout`s — no `dp` width
  or height is fixed in the layouts. Landscape reuses the same weights and only changes
  the panel to one horizontal row of four cells.
* All spacing, text sizes and margins are defined once in `res/values/dimens.xml`
  (`banner_margin`, `panel_padding`, `button_padding`, `label_text_size`, …).
* Icons are vector drawables (`ic_facilities.xml`, `ic_events.xml`, `ic_clubs.xml`,
  `ic_support.xml`), so they stay sharp on every density.
* The two screens reserve space for the bottom navigation bar through
  `WindowInsetsHelper`, while the banner is deliberately drawn behind the status bar.

## Running it

**Android Studio:** *File → Open* this `AssignmentOne` folder, wait for the Gradle
sync, then Run ▶ on the `app` configuration.

**Command line** (from the project folder, JDK 17 on `JAVA_HOME`):

```
gradlew.bat assembleDebug      # Windows
./gradlew assembleDebug        # macOS / Linux
```

The APK is written to `app/build/outputs/apk/debug/app-debug.apk` and was verified on
an API 35 emulator in portrait, landscape and on the detail screen.

## About the images and dummy data

The Canvas resource pack was not available in this workspace, so equivalent stand-ins
are used:

* `drawable-nodpi/banner_campus.jpg` — campus banner photo.
* `drawable/ic_facilities.xml`, `ic_events.xml`, `ic_clubs.xml`, `ic_support.xml` — the
  four white topic icons.
* `values/ic_launcher_background.xml` + `drawable/ic_launcher_foreground.xml` +
  `mipmap-*` — the CampusLife logo and launcher icon.
* `values/arrays.xml` — dummy titles, detail text and icon names.

If the official Canvas assets are supplied, drop the photos/icons into `res/drawable`
and either keep the same file names or update `arrays.xml` / the layout `src` references.
Nothing else needs to change.

## Submission steps (Git)

The repository must be created empty first (no README) so Android Studio can push.

```
git init
git add .
git commit -m "Part A: project setup and Git"
git branch -M main
git remote add origin <your empty [StudentID]-AssignmentOne repository URL>
git push -u origin main
```

Then, for each part, make one commit and one push, for example:

```
git add app/src/main/res/layout/activity_main.xml
git commit -m "Part B: portrait layout"
git push
```

Repeat for `Part C: resources`, `Part D: orientation`, `Part E: onclick events`,
`Part F: detail activity`, `Part G: intent`, `Part H: arrays`, `Part I: code quality`,
and finally paste the repository URL into Canvas.
