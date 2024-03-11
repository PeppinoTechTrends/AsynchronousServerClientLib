package net.techtrends.network.pipeline.in;

import net.techtrends.listeners.input.InputListener;
import net.techtrends.listeners.response.Callback;
import net.techtrends.network.pipeline.Pipeline;

import java.nio.channels.AsynchronousSocketChannel;

public class PipelineIn implements Pipeline {
    private static InputListener inputListener = null;

    public PipelineIn(AsynchronousSocketChannel client, boolean allocateDirect, int initBuffer, int maxBuffer, Callback callback) {
        inputListener = new InputListener(client, allocateDirect, initBuffer, maxBuffer, callback);
        inputListener.start();
    }

    @Override
    public void closePipeline() {
        inputListener.close();
    }

}