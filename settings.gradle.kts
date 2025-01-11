pluginManagement {
    // تعريف مستودعات شائعة
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // تعيين وضع المستودعات إلى PREFER_PROJECT للسماح ببعض المرونة
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
}

// التحقق من وجود الوحدة "app"
if (file("app").exists().not()) {
    throw GradleException("Module 'app' is missing. Make sure it exists in the root directory.")
}

// تعيين اسم المشروع الجذر
rootProject.name = "MyAppWael"

// تضمين الوحدة "app"
include(":app")