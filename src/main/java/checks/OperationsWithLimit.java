package checks;

import awards.Award;

/**
 * Interface for method, that verifies awardAmount and awardSum for Nominator and Nominee
 * @author Aleh_Hutyrchyk
 */
public interface OperationsWithLimit {

    boolean isLimitReached();

    boolean isLimitReached(Award award);

    boolean isQuantityLimitReached();

}
