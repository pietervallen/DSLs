package net.vallen;

import java.util.*;

class State {
  private String name;
  private List<Command> actions = new ArrayList<Command>();
  private Map<String, Transition> transitions = new HashMap<String, Transition>();

  State(String name) {
    this.name = name;
  }

  void addTransition(Event event, State targetState) {
    assert null != targetState;
    transitions.put(event.getCode(), new Transition(this, event, targetState));
  }

  Collection<State> getAllTargets() {
    List<State> result = new ArrayList<State>();
    for (Transition t : transitions.values()) {
      result.add(t.getTarget());
    }
    return result;
  }

  boolean hasTransition(String eventCode) {
    return transitions.containsKey(eventCode);
  }

  State targetState(String eventCode) {
    return transitions.get(eventCode).getTarget();
  }

  void executeActions(CommandChannel commandsChannel) {

    for (Command c : actions) {
      commandsChannel.send(c.getCode());
    }
  }

  protected void addAction(Command command) {
    this.actions.add(command);
  }

}
