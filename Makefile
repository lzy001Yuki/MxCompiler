.PHONY: build
build:
	find -name '*.java' | xargs javac -d bin -cp /ulib/antlr-4.7.2-complete.jar

.PHONY: run
run:
	cd bin && java -cp /ulib/antlr-4.7.2-complete.jar:. Main

.PHONY: main
main:
	find -name '*.java' | xargs javac -d bin -cp ulib/antlr-4.7.2-complete.jar

.PHONY: test
test:
	@cd bin && java -cp ../ulib/antlr-4.7.2-complete.jar:. Main

.PHONY: visit
visit:
	java -cp ulib/antlr-4.7.2-complete.jar org.antlr.v4.Tool $* -no-listener -visitor MxParser.g4