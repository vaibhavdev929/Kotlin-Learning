package days.day3.delegation

/**
 *  ==============  Class/Interface Delegation ==================================================

 *  Kotlin allows you to delegate the responsibility of implementing interface methods
 *  to another object. This helps in code reusability and makes the design more flexible.
 *  Here we have two different engine types: ElectricEngine and FuelEngine, and we delegate
 *  their responsibilities to concrete implementations.
 */

interface ElectricEngine {
    // Interface representing an electric engine with its specific methods
    fun runElectric()                   // Specifies that the engine runs on electricity
    fun transmissionElectricType()      // Specifies the type of transmission in the electric engine
}

interface FuelEngin {
    // Interface representing a fuel engine with its specific methods
    fun runFuelEngine()                 // Specifies that the engine runs on fuel
    fun transmissionFuelType()          // Specifies the type of transmission in the fuel engine
}

class ElectricEngineImp : ElectricEngine {
    // Concrete class implementing the ElectricEngine interface
    override fun runElectric() {
        println("Run on electric")      // Prints that the engine runs on electricity
    }

    override fun transmissionElectricType() {
        println("No Manual Transmission")  // Prints that electric engines do not have manual transmission
    }
}

class FuelEngineImp : FuelEngin {
    // Concrete class implementing the FuelEngin interface
    override fun runFuelEngine() {
        println("Run on fuel")          // Prints that the engine runs on fuel
    }

    override fun transmissionFuelType() {
        println("Manual Transmission")  // Prints that the fuel engine has a manual transmission
    }
}

class EngineRepository : ElectricEngine by ElectricEngineImp(), FuelEngin by FuelEngineImp() {
    // EngineRepository class delegates the implementation of ElectricEngine and FuelEngin interfaces
    // - The ElectricEngine interface methods are delegated to the ElectricEngineImp class
    // - The FuelEngin interface methods are delegated to the FuelEngineImp class
    // This allows EngineRepository to access both electric and fuel engine methods without implementing them directly.
}

/**
 *  In the main function, we will create an instance of EngineRepository and call the methods,
 *  observing how the method calls are delegated to the appropriate engine classes.
 */

fun main() {
    val engineRepository = EngineRepository()

    // Calling methods from ElectricEngine via delegation
    engineRepository.runElectric()                // Delegated to ElectricEngineImp's runElectric() method
    engineRepository.transmissionElectricType()    // Delegated to ElectricEngineImp's transmissionElectricType() method

    // Calling methods from FuelEngin via delegation
    engineRepository.runFuelEngine()               // Delegated to FuelEngineImp's runFuelEngine() method
    engineRepository.transmissionFuelType()        // Delegated to FuelEngineImp's transmissionFuelType() method
}


/**

Here are a few use cases where Kotlin delegation would be beneficial:

1. Reusing Implementations Across Multiple Classes
Use Case: You have different classes that need to share similar behavior, but you don’t want to repeat code in each class.
Example: You might have various Vehicle classes (Car, Truck, Bike), and you can delegate the implementation of an interface (e.g., Engine) to a shared Engine class to avoid duplicating code across all vehicle types.
Why use delegation? Reuse common code across multiple classes by delegating to shared implementations.

2. Adding Behavior Dynamically
Use Case: When you want to add functionality dynamically to a class without altering its inheritance or the main class structure.
Example: A logging functionality could be added by delegating a Logger interface to an implementation class. The class using it doesn't have to modify its original behavior, it just "borrows" the logging behavior dynamically.
Why use delegation? Add behaviors dynamically without modifying or extending the original class.

3. Multiple Interface Implementation
Use Case: You need a class to implement multiple interfaces, but you want to keep each interface's implementation modular.
Example: In the code above, EngineRepository implements both ElectricEngine and FuelEngin interfaces by delegating to two separate classes, ElectricEngineImp and FuelEngineImp. This keeps the code clean and modular.
Why use delegation? Allows separation of concerns by implementing multiple interfaces without directly handling all logic in one class.

4. Reducing Boilerplate in Common Patterns
Use Case: When you have a class that should have a lot of standard or boilerplate functionality provided by another class.
Example: A Repository pattern where you want to share database operations across multiple repositories. You can delegate common database operations to a base class and let individual repositories focus on their specific logic.
Why use delegation? Minimize the boilerplate code for shared logic, keeping the main class focused on its specific purpose.

5. Composing Behavior from Multiple Sources
Use Case: You want a class to compose behavior from multiple sources or classes without multiple inheritance.
Example: In a gaming system, a character might have abilities from multiple sources, such as walking and flying, but instead of using complex inheritance, you can delegate to Walkable and Flyable interfaces, each having its own implementation.
Why use delegation? Achieve composition over inheritance by combining behaviors from different sources without complicated class hierarchies.

6. Switching Behavior at Runtime
Use Case: You need to switch the implementation or behavior of certain methods dynamically at runtime.
Example: In an application where the vehicle's engine type changes (e.g., switching from electric to fuel-based), you can swap delegates at runtime based on user preferences or system conditions.
Why use delegation? Flexibly switch implementation based on runtime conditions.


Summary
Use Kotlin delegation when you:

Need to reuse implementation across multiple classes.
Want to compose or add behavior dynamically without altering class hierarchies.
Are dealing with multiple interface implementations that you want to keep modular.
Need to reduce boilerplate code by delegating standard functionality.
Want the flexibility of switching behaviors at runtime.
These use cases demonstrate how Kotlin delegation improves code flexibility, modularity, and maintainability.

 */


