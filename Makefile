

all:
	javac -d bin *.java

run:
	javac -d bin *.java && java -cp bin Main

exec:
	java -cp bin Main

clean:
	rm bin/*
