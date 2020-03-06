# 113 Intro to Computer Architecture Coursework

## Coursework 5 - Addressing Mode

#### 1

| Operand          | Type      | Memory Address | Value |
| ---------------- | --------- | -------------- | ----- |
| %rax             | register  | -              | 0x2   |
| 0x210            | memory    | 0x210          | 0x11  |
| $0x210           | immediate | -              | 0x210 |
| (%rcx)           | memory    | 0x204          | 0xFF  |
| 4(%rcx)          | memory    | 0x208          | 0xCD  |
| 5(%rcx, %rdx)    | memory    | 0x20C          | 0x21  |
| 519(%rdx, %rax)  | memory    | 0x20C          | 0x21  |
| 0x204(, %rax, 4) | memory    | 0x20C          | 0x21  |
| (%rcx, %rax, 2)  | memory    | 0x208          | 0xCD  |

#### 2

- movl %eax, (%esp)
- movw (%esp, %edx, 4), %dx
- movb $0x21, %al
- movb (%eax), %dh
- movb $-17, (%esp)
- movw $dx, (%esp)
- movq $rax, -12(%rbp)

#### 3

- Cannot use %bl as address register
- %ax is only 16 bytes. It should be movw
- Cannot move from memory to memory in one single instruction
- No register called %sh
- Cannot move something to a constant(immediate)
- %dx is only 16 bytes. It should be movzlw

