(: Name: following-14 :)
(: Description: Evaluation of the following axis that is part of an "except" operation. Both operands are the same. :)
(: Uses fn:count to avoid empty file :)

(: insert-start :)
declare variable $input-context1 external;
(: insert-end :)

fn:count(($input-context1/works[1]/employee[12]/following::employee) except ($input-context1/works[1]/employee[12]/following::employee))