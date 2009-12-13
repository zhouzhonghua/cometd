package org.cometd.bayeux;

import java.util.EventListener;



/**
 * @version $Revision$ $Date: 2009-12-08 09:42:45 +1100 (Tue, 08 Dec 2009) $
 */
public interface ClientSession extends Client
{
    ChannelClient getChannelSession(String channelName);

    void batch(Runnable batch);

    void disconnect();
    
    void addListener(Listener listener);

    interface Listener extends EventListener
    {};
}
