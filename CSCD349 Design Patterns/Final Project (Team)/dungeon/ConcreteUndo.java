package dungeon;


import java.util.Stack;

public class ConcreteUndo implements Command {
    private Stack<Momento> momentoStack;

    public ConcreteUndo() {
        this.momentoStack = new Stack<Momento>();
    }
    public void add(Momento m) {
        //System.out.println("Adding momento to stack");
        this.momentoStack.push(m);
    }
    @Override
    public Momento undo() {
        System.out.println("Restoring state");
        return this.momentoStack.pop();
    }
    public int size() {
        return this.momentoStack.size();
    }

    // do this tomorow, return a momento object that will contain a hero and
    // monster list

}
