package com.bot.worker.taskmanager;

import com.bot.common.ITaskGroup;
import com.bot.common.ITaskResultProcessor;
import com.bot.common.TaskResult;
import com.google.common.collect.ImmutableList;

import javax.inject.Inject;

/**
 * Created by Aleks on 11/23/16.
 */
public class TaskResultProcessorDecorator implements ITaskResultProcessor {

    private final ImmutableList<ITaskResultProcessor> processors;

    @Inject
    public TaskResultProcessorDecorator(ImmutableList<ITaskResultProcessor> processors) {
        this.processors = processors;
    }

    @Override
    public void processResult(TaskResult result, ITaskGroup group) {
        processors.forEach((processor) -> processor.processResult(result, group));
    }
}
