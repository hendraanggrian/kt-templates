val RELEASE_GROUP: String by project
val RELEASE_ARTIFACT: String by project

plugins {
    alias(libs.plugins.android.library)
    kotlin("android") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
    testNamespace = "$namespace.test"
    buildFeatures.buildConfig = false
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    ktlintRuleset(libs.ktlint)
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(project(":$RELEASE_ARTIFACT"))
    implementation(libs.kotlinx.coroutines)
    implementation(libs.androidx.appcompat)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.bundles.androidx.test)
}
