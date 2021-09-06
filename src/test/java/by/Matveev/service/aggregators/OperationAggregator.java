package by.Matveev.service.aggregators;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class OperationAggregator implements ArgumentsAggregator {
    @Override
    public Operation aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
        return new Operation(argumentsAccessor.getDouble(0), argumentsAccessor.getDouble(1),
                argumentsAccessor.getString(2),
                new User()
                );
    }
}
