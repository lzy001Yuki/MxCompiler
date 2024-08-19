#define bool _Bool
int printf(const char *pattern, ...);
int sprintf(char *dest, const char *pattern, ...);
int scanf(const char *pattern, ...);
int sscanf(const char *src, const char *pattern, ...);
unsigned strlen(const char *str);
int strcmp(const char *s1, const char *s2);
void *memcpy(void *dest, const void *src, unsigned n);
void *malloc(unsigned n);

char* _malloc_(int n) {
    return malloc(n);
}

void print(char *str){
    printf("%s",str);
}

void println(char *str) {
    printf("%s\n", str);
}

void printInt(int x) {
    printf("%d", x);
}

void printlnInt(int x) {
    printf("%d\n", x);
}

int getInt() {
    int x;
    scanf("%d", &x);
    return x;
}

char* getString() {
    char* str = malloc(256);
    scanf("%s", str);
    return str;
}

int string_length(char *str) {
    return strlen(str);
}

int string_ord(char *str,int i){
    return str[i];
}

bool string_eq(char *lhs, char *rhs){
    return strcmp(lhs, rhs) == 0;
}

bool string_ne(char *lhs, char *rhs){
    return strcmp(lhs, rhs) != 0;
}

bool string_slt(char *lhs, char *rhs){
    return strcmp(lhs, rhs) < 0;
}

bool string_sgt(char *lhs, char *rhs){
    return strcmp(lhs, rhs) > 0;
}

bool string_sge(char *lhs, char *rhs){
    return strcmp(lhs, rhs) >= 0;
}

bool string_sle(char *lhs, char *rhs){
    return strcmp(lhs, rhs) <= 0;
}

int array_size(int *a) {
    return *(a-1);
}

char* toString(int a) {
    char* ans = malloc(256);
    sprintf(ans, "%d", a);
    return ans;
}

char* string_add(char* lhs, char* rhs) {
    char* ans = malloc(512);
    for (int i = 0; i < strlen(lhs); i++) {
        ans[i] = lhs[i];
    }
    for (int i = 0; i < strlen(rhs); i++) {
        ans[i + strlen(lhs)] = rhs[i];
    }
    return ans;
}

char* string_substring(char* str, int l, int r) {
     char *ans = malloc(256);
     for(int i = l;i<r;++i){
        ans[i-l] = str[i];
     }
     ans[r-l] = '\0';
     return ans;
}

int string_parseInt(char *str){
    int x;
    sscanf(str,"%d",&x);
    return x;
}