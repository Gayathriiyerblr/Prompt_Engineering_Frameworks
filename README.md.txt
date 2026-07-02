Provide the Anti Hallucination rules first
Attach the BRD/ Specification document

if any specific format provide that as the prompt
--------------------------------------------------------------

Analyze this bug report step by step:

Step 1: Identify the reported symptoms
Step 2: List possible root causes
Step 3: Determine what information is missing
Step 4: Suggest next debugging steps

Bug Report: "Checkout fails intermittently on mobile"

----------------------------------------------------------------
QA use :
1. Generate Generic Test Case - Zero-Shot
2.Generate test case in custom template - Few shot
3. Analyze complex bug report - Chain of thought
4. Write API test - Few-Shot
5. Review Test coverage - Chain of thought
6. Convert requirement to test - Few-shot

------------------------------------------------------------------
## Advanced: Combining Types
For best results, combine techniques:

```
ROLE: Senior QA Engineer

TASK: Analyze this PRD and generate test cases.

CHAIN-OF-THOUGHT:
1. First, extract all testable requirements
2. Then, identify edge cases
3. Finally, generate test cases

FEW-SHOT EXAMPLE:
| TC_001 | Requirement: User login | Steps: Enter credentials | Expected: Dashboard shown |

CONSTRAINTS:
- Use ONLY BRD content and FIGMA
- Mark assumptions explicitly

BRD:
[paste BRD, FIGMA]
-----------------------------------------------------------------------------
## Checklist: Is Your Prompt Complete?
- [ ]  Role defined
- [ ]  Context provided
- [ ]  Task is specific and quantified
- [ ]  Constraints prevent hallucinations
- [ ]  Output format specified
- [ ]  Terminology defined if needed

----------------------------------------------------------------------------------
