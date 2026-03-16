plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.3.0"
}

group = providers.gradleProperty("pluginGroup").get()
version = providers.gradleProperty("pluginVersion").get()

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity(providers.gradleProperty("platformVersion").get())
        instrumentationTools()
    }
}

intellijPlatform {
    pluginConfiguration {
        id = "com.github.ota.claudetheme"
        name = "Claude Theme"
        version = providers.gradleProperty("pluginVersion").get()
        description = """
            <h2>Claude Theme for IntelliJ IDEA</h2>
            <p>A warm, refined color theme inspired by <b>Claude</b> — Anthropic's AI assistant.</p>
            <p>Includes <b>dark</b> and <b>light</b> variants with carefully chosen colors
            for comfortable, extended coding sessions.</p>
            <h3>Features</h3>
            <ul>
              <li>Full IDE theming — editor, toolbars, tabs, panels, popups, trees, and more</li>
              <li>Custom editor color schemes with syntax highlighting</li>
              <li>Recolored icons matching each theme's palette</li>
              <li>Warm accent colors (orange/terracotta) throughout</li>
            </ul>
        """.trimIndent()
        changeNotes = """
            <ul>
              <li><b>1.0.0</b> — Initial release with Claude Dark and Claude Light themes.</li>
            </ul>
        """.trimIndent()
        ideaVersion {
            sinceBuild = "243"
        }
        vendor {
            name = "ota"
        }
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
    }

    buildSearchableOptions = false
}

tasks {
    wrapper {
        gradleVersion = "8.12"
    }
}
