# Change the src to the path of your java source files
JAVA_SRC = $(shell find src -name '*.java')
# Change this to the path of your antlr jar
ANTLR_JAR = /ulib/antlr-4.13.1-complete.jar

.PHONY: all
all: Main

.PHONY: Main
Main: $(JAVA_SRC)
	javac -d bin $(JAVA_SRC) -cp $(ANTLR_JAR)

.PHONY: clean
clean:
	find bin -name '*.class' -or -name '*.jar' | xargs rm -f
