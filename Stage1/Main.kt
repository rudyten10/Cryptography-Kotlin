package cryptography
// Stage 1/4: Program interface

enum class State {MENU, WRAPUP, EXIT, BACK, HIDE, SHOW}

class Cryptography (){

    var state: State = State.MENU
    fun menu(): State {
        println("Task (hide, show, exit):")
        val command = readLine()!!
        if (command == "exit" || command == "e") {
            return State.WRAPUP
        } else if (command == "show" || command == "s") {
            return State.SHOW
        } else if (command == "hide" || command == "h") {
            return State.HIDE
        } else {
            println("Wrong task: $command")
            //width = command.toInt()
        }

        return State.MENU
    }
    fun runSystem(){
        //width = 99
        when (state){
            State.MENU -> state = menu()
            State.SHOW -> state = doShow()
            State.HIDE -> state = doHide()
            State.BACK -> state = menu()
            State.WRAPUP -> state = exitSystem()
            else -> throw UnsupportedOperationException("Unexpected state")
        }
    }

    fun doShow(): State{
        println("Obtaining message from image.")

        return State.MENU
    }

    fun doHide(): State{
        println("Hiding message in image.")

        return State.MENU
    }

    fun exitSystem(): State{
        println("Bye!")

        return State.EXIT
    }
}

fun main() {
    Cryptography().run {
        do  runSystem() while ( state != State.EXIT)
    }
}