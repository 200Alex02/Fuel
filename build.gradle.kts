buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
        classpath(Hilt.hiltAgp)
    }
}