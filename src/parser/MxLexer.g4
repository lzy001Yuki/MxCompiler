lexer grammar MxLexer;
Main : 'main';
Void : 'void';
Bool : 'bool';
Int : 'int';
String : 'string';
New : 'new';
Class : 'class';
Null : 'null';
True : 'true';
False : 'false';
This : 'this';
If : 'if';
Else : 'else';
For : 'for';
While : 'while';
Break : 'break';
Continue : 'continue';
Return : 'return';

Head : 'f"' FormatStr '$';
Middle : '$' FormatStr '$';
Tail : '$' FormatStr Quote;

Identifier:[A-Za-z][A-Za-z0-9_]*;
Add:'+';
Sub:'-';
Mul:'*';
Div:'/';
Mod:'%';

GT:'>';
LT:'<';
GET:'>=';
LET:'<=';
NEQ:'!=';
EQ:'==';

And : '&';
Or : '|';
AndAnd : '&&';
OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';
LeftShift : '<<';
RightShift : '>>';

Assign:'=';
Incre:'++';
Decre:'--';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';
Dot : '.';
Quote : '"';


LParen : '(';
RParen : ')';
LBracket : '[';
RBracket : ']';
LBrace : '{';
RBrace : '}';
Integer:[1-9][0-9]* | '0';

Str : Quote ('\\n' | '\\\\' | '\\"' | [ !#-[\]-~])* Quote;
fragment FormatStr : ('\\n' | '\\\\' | '\\"' | [ !#%-[\]-~] | '$$')*;
Format1 : 'f"' FormatStr '"';
Whitespace:[ \t]+ ->skip;
Newline: ('\r''\n'? |'\n')->skip;
BlockComment:'/*' .*?'*/'->skip;
LineComment:'//' ~[\r\n]*->skip;