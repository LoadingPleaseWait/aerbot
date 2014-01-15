package com.bellaire.aerbot.listeners;

import com.bellaire.aerbot.Environment;

public interface Listener {
    
    public void init(Environment env);
    
    public boolean isListening();
    
    public boolean shouldExecute();
    
    public void execute();
    
}
