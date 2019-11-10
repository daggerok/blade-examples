import org.gradle.api.JavaVersion

object Globals {
  const val version = "0.0.1-SNAPSHOT"
  const val groupId = "com.github.daggerok.blade"
  const val mainClass = "com.github.daggerok.blade.AppKt"

  const val gradleWrapperVersion = "5.6.4"

  val javaVersion = JavaVersion.VERSION_11
  const val bladeVersion = "2.0.15.BETA"

  const val kotlinVersion = "1.3.50"
  val freeCompilerArgs = listOf("-Xjsr305=strict")
  val jvmTarget = JavaVersion.VERSION_11.toString()

  // const val vavrVersion = "0.10.2"
  // const val lombokVersion = "1.18.10"
  const val junitJupiterVersion = "5.5.2"
  const val assertjVersion = "3.13.2"
}
