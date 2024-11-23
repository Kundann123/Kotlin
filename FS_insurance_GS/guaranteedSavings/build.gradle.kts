
plugins {
    id("finance.kotlin-application-conventions")
}

group = "com.tdl.guaranteedsavings"
version = "0.0.1"
application {
    mainClass.set("com.tdl.guaranteedsavings.ApplicationKt")
}

dependencies {
    implementation("io.ktor:ktor-serialization-gson-jvm:2.1.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("com.intuit.karate:karate-core:1.2.0")
    implementation("org.quartz-scheduler:quartz:2.3.2")
    implementation("com.intuit.fuzzymatcher:fuzzy-matcher:1.2.0")
    implementation("me.xdrop:fuzzywuzzy:1.4.0")
}
