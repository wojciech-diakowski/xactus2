(: Name: following-7 :)
(: Description: Evaluation of the following axis that is part of an "node before" expression both operands are differents (return false). :)

(: insert-start :)
declare variable $input-context1 external;
(: insert-end :)

($input-context1/works[1]/employee[12]/following::employee) << ($input-context1/works[1]/employee[12]/overtime[1])