import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm") version Globals.kotlinVersion
}

tasks {
    withType<Wrapper> {
        gradleVersion = Globals.gradleWrapperVersion
    }
}

defaultTasks("clean", "build")

allprojects {
    apply<BasePlugin>()
    group = Globals.groupId
    version = Globals.version

    apply<JavaPlugin>()
    java.targetCompatibility = Globals.javaVersion

    apply<KotlinPlatformJvmPlugin>()
    sourceSets["main"].resources.srcDir("src/main/resources")
    sourceSets["main"].java.srcDirs(
            "src/main/java",
            "src/main/kotlin "
    )

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("com.bladejava:blade-mvc:${Globals.bladeVersion}")
        testImplementation("org.junit.jupiter:junit-jupiter:${Globals.junitJupiterVersion}")
        testImplementation("org.assertj:assertj-core:${Globals.assertjVersion}")
        // testImplementation("org.mockito:mockito-junit-jupiter")
    }

    tasks {
        build {
            dependsOn("processResources")
        }
        withType<Test> {
            useJUnitPlatform()
        }
        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = Globals.freeCompilerArgs
                jvmTarget = Globals.jvmTarget
            }
        }
    }
}

subprojects {
    apply<ApplicationPlugin>()
    configure<ApplicationPluginConvention> {
        mainClassName = Globals.mainClass
    }
}
