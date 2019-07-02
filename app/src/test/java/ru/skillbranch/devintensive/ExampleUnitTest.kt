package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Cena")
    }

    @Test
    fun test_factory() {
//        val user = User.makeUser("John Cena")
//        val user2 = User.makeUser("John Wick")
        val user3 = User.makeUser("John Wick")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date())
        val user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

//        val user = User.makeUser("John Cena")
//        val user2 = User.makeUser("John Wick")
//        val user3 = User.makeUser("John Wick")
    }

    @Test
    fun test_dataq_maping() {
        val user = User.makeUser("Урамов Владислав")
        val newUser = user.copy(lastVisit = Date().add(-4, TimeUnits.DAY))
        println(newUser)
        val userView = user.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Урамов Владислав")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")
        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

    @Test
    fun test_initials(){
        println(Utils.toInitials("Aaa","Bbb"))
        println(Utils.toInitials("aaa",null))
        println(Utils.toInitials(null,"bbb"))
        println(Utils.toInitials(null,null))
        println(Utils.toInitials("",""))
        println(Utils.toInitials(" ",""))
    }

}
