pluginManagement {
    repositories {
        maven {
            url = uri("https://nexus.partdp.ir/repository/part-android/")
            credentials {
                username = "android-user"
                password = "EL2BB+*wkXEaydY=/2>2Kx-tV4CV-%"
            }
            content {
                excludeGroupByRegex("ir\\.part*.*")
            }
        }

        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("https://nexus.partdp.ir/repository/part-android/")
            credentials {
                username = "android-user"
                password = "EL2BB+*wkXEaydY=/2>2Kx-tV4CV-%"
            }
            content {
                excludeGroupByRegex("ir\\.part*.*")
            }
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "Navigate With Command"

include(":app")
include(":home")
include(":goldoon")
include(":livan")
include(":base-ui")
