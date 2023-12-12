val navVersion by extra { "2.7.5" }
val roomVersion by extra { "2.6.0" }
val hiltVersion by extra { "2.46.1" }
val retrofitVersion by extra { "2.9.0" }

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
}