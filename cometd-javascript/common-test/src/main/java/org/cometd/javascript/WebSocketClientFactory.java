/*
 * Copyright (c) 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cometd.javascript;

import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.websocket.client.masks.ZeroMasker;
import org.mozilla.javascript.ScriptableObject;

public class WebSocketClientFactory extends ScriptableObject
{
    private org.eclipse.jetty.websocket.client.WebSocketClientFactory factory;
    private QueuedThreadPool threadPool;

    public WebSocketClientFactory()
    {
    }

    public void jsConstructor()
    {
    }

    public String getClassName()
    {
        return "WebSocketClientFactory";
    }

    public void start() throws Exception
    {
        threadPool = new QueuedThreadPool();
        factory = new org.eclipse.jetty.websocket.client.WebSocketClientFactory(threadPool);
        factory.setMasker(new ZeroMasker());
        factory.start();
    }

    public void stop() throws Exception
    {
        factory.stop();
    }

    public org.eclipse.jetty.websocket.client.WebSocketClient newWebSocketClient(Object target)
    {
        return factory.newWebSocketClient(target);
    }
}
