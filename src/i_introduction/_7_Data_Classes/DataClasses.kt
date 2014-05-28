package i_introduction._7_Data_Classes

import util.TODO

class Person1(val name: String, val age: Int)

//no 'new' keyword
fun create() = Person1("James Gosling", 58)

fun useFromJava() {
    // property 'val name' = backing field + getter
    // => from Java you access it through 'getName()'
    JavaCode7().useKotlinClass(Person1("Martin Odersky", 55))

    // property 'var mutable' = backing field + getter + setter
}

// It's the same as the following (getters are generated by default):
class Person2(_name: String, _age: Int) { //_name, _age are constructor parameters
    val name: String = _name //property initialization is the part of constructor
      get(): String {
          return $name // you can access the backing field of property with '$' + property name
      }

    val age: Int = _age
      get(): Int {
          return $age
      }
}

// If you add annotation 'data' for your class, some additional methods will be generated for you
// like 'equals', 'hashCode', 'toString'.

data class Person3(val name: String, val age: Int)

// This class is as good as Person4 (written in Java), 42 lines shorter. =)

fun todoTask7() = TODO(
    """
        There is no task for you here.
        Just make sure you're not forgetting to read carefully all code examples and comments and
        ask questions if you have any. =) Then return 'true' from 'task7'.
        More information about classes in kotlin can be found in syntax/classesObjectsTraits.kt
    """,
    references = { JavaCode7.Person4("???", -1) }
)

fun task7(): Boolean = true