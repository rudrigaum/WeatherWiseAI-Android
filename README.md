# WeatherWise AI 🌤️

**Plan smarter. Let the weather guide your decisions.**

WeatherWise AI is a native Android application designed to help people plan everyday activities, events, and travel using weather data and AI-powered contextual recommendations.

Rather than simply displaying temperatures and forecasts, WeatherWise AI aims to transform reliable meteorological information into practical guidance.

> **Project Status:** Early development. The initial Android project, Gradle configuration, and testing infrastructure are available. The application currently displays the default Jetpack Compose template. Weather data integration, AI features, navigation, and the custom Design System are not yet implemented.

## Overview

WeatherWise AI aims to answer questions such as:

- "What's the best time to go running this weekend?"
- "Will it be too hot for a football match tomorrow?"
- "Should I bring a jacket to a concert next month?"
- "Is tomorrow a good day to visit the beach?"

The application will interpret user intentions, identify relevant dates and locations, retrieve appropriate meteorological information, and provide recommendations grounded in validated weather data.

The project also demonstrates native Android engineering, AI integration, software architecture, accessibility, and automated testing.

## Planned MVP

### Home

- Current weather conditions for the selected location.
- Hourly weather overview.
- Contextual activity suggestions.
- Optional approximate device location.
- Manual city selection.

### AI Planner

- Free-form natural language questions.
- Optional activity suggestion shortcuts.
- Interpretation of dates, locations, and activities.
- Clarification requests when essential information is missing.
- Explicit locations and dates take precedence over device location.

### AI Analysis

- Context-aware weather recommendations.
- Structured results rendered through native UI components.
- Explanations grounded in validated meteorological data.
- Weather source attribution.
- Clear communication of uncertainty and unavailable information.

### Forecast

- Hourly and daily weather forecasts.
- Relevant meteorological indicators.
- Historical weather information for dates outside the forecast horizon.
- Clear distinction between forecasts, historical information, and unavailable data.

The main navigation will contain three destinations: Home, Planner, and Forecast. AI Analysis will be accessed through the Planner flow.

## Technology Stack

| Category | Technology | Status |
|---|---|---|
| Language | Kotlin | Configured |
| User Interface | Jetpack Compose + Material 3 | Configured |
| IDE | Android Studio 2026.2.2 Patch 1 | Development environment |
| Gradle | 9.6.0 | Configured |
| Android Gradle Plugin | 9.5.2 | Configured |
| Compose BOM | 2026.02.01 | Configured |
| Gradle Daemon JVM | Java 25 | Configured |
| Java Source/Target Compatibility | Java 17 | Configured |
| Minimum Android Version | API 26 / Android 8.0 | Configured |
| Compile SDK | API 37 | Configured |
| Target SDK | API 37 | Configured |
| Architecture | Clean Architecture + MVVM | Planned |
| State Management | StateFlow + UDF | Planned |
| Concurrency | Kotlin Coroutines + Flow | Planned |
| Navigation | Navigation Compose with type-safe routes | Planned |
| Dependency Injection | Hilt + constructor injection | Planned |
| Weather Provider | Open-Meteo | Planned |
| AI Integration | Secure backend / API gateway | Planned |
| Networking | Retrofit/OkHttp or Ktor | Under evaluation |
| Local Persistence | Room, if required | Under evaluation |
| Unit Testing | JUnit 4 | Initial dependency configured |
| UI Testing | Compose UI Test + AndroidX Test | Initial dependencies configured |
| Code Quality | Android Lint | Available |
| Formatting | ktlint | Planned |
| CI/CD | GitHub Actions | Planned |
| Static Analysis | SonarQube Cloud | Under evaluation |

The Version Catalog currently declares Kotlin Compose plugin version 2.2.10. Kotlin and Android Gradle Plugin compatibility will be reviewed before further build-tooling changes.

The project prioritizes native Android components and avoids unnecessary external dependencies.

## Architecture

WeatherWise AI will follow **Clean Architecture + MVVM**, with Unidirectional Data Flow (UDF).

The intended architecture separates three principal responsibilities.

### Domain

- Business entities and rules.
- Use cases when meaningful.
- Repository contracts when dependency inversion is needed.
- Domain-specific error handling.
- Testable weather interpretation and validation rules.

### Data

- API clients and remote data sources.
- Network DTOs and serialization.
- Explicit DTO-to-domain mapping.
- Repository implementations.
- Infrastructure error translation.

### Presentation

- Jetpack Compose screens and reusable components.
- ViewModels exposing immutable `StateFlow<UiState>`.
- Private mutable state within ViewModels.
- Stateless UI components where practical.
- Navigation callbacks and user interactions.
- Loading, success, empty, and error states.

### State Management

The application will follow Unidirectional Data Flow:

- UI state flows from ViewModels to Composables.
- User events flow from Composables to their handlers.
- ViewModels coordinate presentation logic and domain operations.
- UI state collection respects the Android lifecycle.

Navigation will use type-safe destinations based on Kotlin Serialization.

Dependency injection will favor constructor injection with Hilt where appropriate.

The initial application uses a single Gradle module, `:app`. Additional modules will be introduced only when their benefits justify the additional build complexity.

The architecture will evolve incrementally rather than introducing unnecessary abstractions before concrete requirements exist.

## Weather Data and AI Integration

WeatherWise AI plans to use [Open-Meteo](https://open-meteo.com/) for weather forecasts and historical meteorological information.

Forecast availability depends on the supported forecasting model and endpoint, with some forecasts extending up to 16 days.

For requests outside the available forecast horizon, the application must provide clearly labeled historical context rather than an exact future prediction.

### Planned AI Analysis Flow

1. The user describes an activity or event.
2. The system identifies the relevant intent, date, time, and location.
3. Appropriate weather information is retrieved.
4. Deterministic rules validate weather measurements and relevant conditions.
5. The AI generates contextual explanations based on validated facts.
6. The application renders a structured, source-aware result.

### AI Safety and Reliability

- The AI must not invent temperatures, precipitation probabilities, event schedules, or data sources.
- Historical weather information must never be presented as an exact future forecast.
- Essential ambiguities must trigger clarification when necessary.
- Structured backend responses must be validated.
- Timeouts, cancellation, network errors, and malformed responses must be handled.
- Private AI provider credentials must never be embedded in the Android application.
- The backend provider, request limits, and budget are still to be determined.

The initial MVP will not independently verify whether a referenced concert, football match, or other event is actually scheduled.

## Privacy and Security

Privacy is a core architectural requirement.

- Device location access will be optional.
- Approximate location will be preferred when sufficient.
- Location permission will only be requested in the context of a relevant feature.
- Users will be able to select cities manually.
- Background location tracking is outside the MVP scope.
- Explicit locations in user questions will take precedence over device location.
- Unnecessary personal information and precise coordinates will not be sent to AI services.
- Private backend and AI provider credentials will not be embedded in the APK.

## Accessibility and Localization

The application will prioritize:

- TalkBack-compatible semantics and content descriptions.
- Scalable typography and accessible layouts.
- Sufficient text and interface contrast.
- Accessible touch targets.
- Clear loading, empty, and error states.
- Meaningful feedback for interactive components.
- Brazilian Portuguese localization.
- Light and Dark Mode support.

Accessibility will be considered throughout implementation rather than added only after the visual features are completed.

## Getting Started

### Requirements

- Android Studio with Jetpack Compose support.
- Android SDK API 37 installed.
- A compatible JDK and Gradle environment.
- An Android emulator or physical device running Android 8.0 or later.
- Git.

The project uses the Gradle Wrapper and declares Java 25 for its Gradle Daemon. Java source and target compatibility are configured for Java 17.

### Clone the Repository

1. Run `git clone https://github.com/rudrigaum/WeatherWiseAI-Android.git`.
2. Run `cd WeatherWiseAI-Android`.
3. Open the project directory in Android Studio.
4. Allow Gradle synchronization to finish.
5. Select an Android emulator or compatible physical device.
6. Build and run the `app` configuration.

The application currently displays the default Jetpack Compose template.

### Command-Line Build

Run `./gradlew :app:assembleDebug` from the repository root.

### Android Lint

Run `./gradlew :app:lintDebug`.

### Unit Tests

Run `./gradlew :app:testDebugUnitTest`.

### Instrumented Tests

With a compatible emulator or physical device connected, run `./gradlew :app:connectedDebugAndroidTest`.

The initial Debug build, unit test Gradle task, and Android Lint task were validated locally. Instrumented tests have not yet been confirmed.

Meaningful feature-specific test coverage will be introduced as implementation progresses.

## Testing Strategy

The planned testing strategy prioritizes:

- Domain business rules and use cases.
- Weather DTO mapping and data validation.
- ViewModel state transitions.
- Coroutines and Flow behavior.
- Location permission handling.
- Date and location interpretation.
- Network failures and retry behavior.
- AI response validation.
- Navigation and accessibility semantics.

Unit tests will use controlled dependencies, test dispatchers, and fakes where appropriate.

Compose UI tests will cover critical user flows, loading states, failures, retry actions, and accessible interactions.

Shared API contract fixtures may be used to validate equivalent backend behavior across Android and iOS without sharing native application source code.

## Roadmap

### Foundation

- [x] Create the Android application using the Empty Activity template.
- [x] Configure Kotlin and Jetpack Compose.
- [x] Configure the Gradle Wrapper and Version Catalog.
- [x] Set minimum SDK to API 26.
- [x] Configure Java 17 source and target compatibility.
- [x] Initialize the Git repository.
- [x] Configure `.gitignore`.
- [x] Validate the initial Debug build.
- [x] Validate the initial unit test Gradle task.
- [x] Validate Android Lint.
- [ ] Complete project documentation and repository governance.
- [ ] Review Kotlin and Android Gradle Plugin compatibility.
- [ ] Configure ktlint.
- [ ] Configure GitHub Actions.
- [ ] Evaluate SonarQube Cloud integration.

### Application

- [ ] Implement Design System v1.0.
- [ ] Implement type-safe main navigation.
- [ ] Implement the Home screen.
- [ ] Integrate Open-Meteo forecasts.
- [ ] Implement manual city selection.
- [ ] Implement optional approximate device location.
- [ ] Implement the AI Planner.
- [ ] Integrate the secure AI backend.
- [ ] Implement the AI Analysis screen.
- [ ] Implement detailed forecasts and historical weather views.
- [ ] Add comprehensive automated tests.
- [ ] Validate accessibility across critical flows.
- [ ] Improve error handling, cancellation, and recovery behavior.

## Cross-Platform Vision

WeatherWise AI is being developed as two independent native applications:

- **Android:** Kotlin and Jetpack Compose.
- **iOS:** Swift and SwiftUI.

Both applications will share product requirements, meteorological interpretation rules, and backend API contracts while preserving platform-native architectures and user interfaces.

The iOS application is maintained separately in the [WeatherWiseAI-iOS repository](https://github.com/rudrigaum/WeatherWiseAI-iOS).

**This repository contains only the Android application.**

## Project Principles

- Clean Architecture and separation of concerns.
- SOLID, DRY, and KISS where appropriate.
- Unidirectional Data Flow.
- Explicit dependency injection.
- Testable business logic.
- Native Android development practices.
- Accessibility by design.
- Privacy and security by design.
- Structured concurrency and lifecycle awareness.
- Incremental development.
- Conventional Commits and Pull Request reviews.
- Documentation of architectural decisions and trade-offs.

## License

A software license has not yet been selected.

The repository is publicly accessible, but no additional reuse or redistribution permissions are granted until a license is explicitly provided.
