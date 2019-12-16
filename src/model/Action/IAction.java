package model.Action;

public interface IAction{
    public void execute();
    public void undo();
    public String getActionName();
}