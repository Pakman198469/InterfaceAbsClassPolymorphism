package checks;

import awards.Award;

/**
 * Created by Aleh_Hutyrchyk on 1/26/2018.
 */
public interface OperationsWithLimit {

    boolean isLimitReached();

    boolean isLimitReached(Award award);

    boolean isQuantityLimitReached();

}
