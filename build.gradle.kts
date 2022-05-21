import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0"
}

repositories {
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    mavenCentral()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.mariuszgromada.math:MathParser.org-mXparser:4.4.2")
}

compose.desktop {
    application {
        mainClass = "jetbrains.compose.calculator.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ComposeDesktopCalculator"
        }
    }
}