package com.bellaire.aerbot;

public interface Listener {
    
    public void init(Environment env);
    
    public boolean isListening();
    
    public boolean shouldExecute();
    
    public void execute();
    
}
