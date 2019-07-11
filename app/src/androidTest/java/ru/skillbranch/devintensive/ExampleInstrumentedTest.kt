package ru.skillbranch.devintensive

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import ru.skillbranch.devintensive.models.User

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("ru.skillbranch.devintensive", appContext.packageName)
    }

    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2")
        val user3 = User("3")

        println("$user $user2 $user3")
    }
}
