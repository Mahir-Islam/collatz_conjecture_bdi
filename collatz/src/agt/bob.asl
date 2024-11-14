!start.

+!start : true <- .print("hello world.");
				  check(121).

+even(X) <- .print(X, " is even");
			!half(X).

+odd(X) : X == 1 <- .print("We have reached one");
                    clear.

+odd(X) : X > 1 <- 	.print(X, " is odd");
		   		   	!triple_and_increment(X).

+!half(X) : true <- check(X / 2).
+!triple_and_increment(X) : true <- check(3*X + 1).
