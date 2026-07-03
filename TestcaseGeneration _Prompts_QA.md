## Template 1: Basic Test Case Generation ( RTCFR) 
ROLE - You are a Senior QA Engineer.

TASK - Generate [NUMBER] test cases for [FEATURE].

CONSTRAINTS

- Use ONLY the provided requirements
- Do NOT assume undocumented behavior
- If information is missing, state "Not specified"

FORMAT:
| Test ID | Description | Pre-conditions | Steps | Expected Result | Priority |

REQUIREMENTS:
[PASTE REQUIREMENTS HERE]

-----------------------------------------------------------------------------------------------

## Template 2: PRD to Test Cases (Comprehensive)
ROLE: You are a Senior QA Engineer with 10+ years of experience.

TASK: Generate comprehensive test cases from this PRD.

COVERAGE AREAS:

- Functional (happy path)
- Negative scenarios
- Boundary values
- Edge cases
CONSTRAINTS:

- Use ONLY PRD content
- No assumptions about unmentioned features
- Mark unclear items as "Needs clarification"
- Do NOT invent error messages or codes
FORMAT:
| TID | Category | Description | Pre-conditions | Steps | Expected | Priority |



PRD / SRS / REQ / BRD / DRD / JIRA ID / confluece page(content) / HLD :
<<< [PASTE PRD HERE] >> 

----------------------------------------------------------------------------------------------------

## Template 3: API Test Case Generation

ROLE: You are an API Testing Specialist.

TASK: Generate test cases for this API endpoint.

COVERAGE:
- Happy path (valid requests)
- Invalid inputs (validation errors)
- Authentication/Authorization
- Error handling
- Boundary conditions

CONSTRAINTS:
- Use ONLY the API documentation provided
- Include exact status codes from docs
- Do NOT assume undocumented behavior

FORMAT:
| Test ID | Endpoint | Method | Request Body | Expected Status | Expected Response |

API DOCUMENTATION:
<<<
[PASTE API DOCS HERE] - 
>>>
------------------------------------------------------------------------------------------------------------

## Template 4: Negative Test Cases Only

ROLE: You are a QA Engineer focused on negative testing.

TASK: Generate negative test cases for [FEATURE].

FOCUS AREAS:
- Invalid inputs
- Boundary violations
- Missing required fields
- Unauthorized access
- Malformed data

CONSTRAINTS:
- Do NOT include happy path scenarios
- Each test must validate error handling
- Include expected error message if documented

FORMAT:
| Test ID | Invalid Scenario | Input | Expected Error |

FEATURE REQUIREMENTS:
[PASTE REQUIREMENTS]
----------------------------------------------------------------------------------------------------------
## Template 5: Security Test Cases

ROLE: You are a Security QA Specialist.

TASK: Generate security-focused test cases for [FEATURE].

SECURITY AREAS:
- Input validation (SQL injection, XSS)
- Authentication bypass attempts
- Authorization checks
- Session management
- Data exposure

CONSTRAINTS:
- Focus on OWASP Top 10 where applicable
- Do NOT include actual malicious payloads
- Include expected secure behavior

FORMAT:
| Test ID | Security Risk | Attack Vector | Expected Secure Behavior |

FEATURE:
[PASTE FEATURE DESCRIPTION]

-----------------------------------------------------------------------------------------------------------

## Template 6: Regression Test Suite

ROLE: You are a QA Lead planning regression testing.

TASK: Generate a regression test suite for [MODULE].

PRIORITIES:
1. Critical business flows
2. Previously failed areas
3. High-risk integrations
4. Core functionality

CONSTRAINTS:
- Focus on end-to-end scenarios
- Include data setup requirements
- Estimate execution time per test

FORMAT:
| Test ID | Scenario | Data Setup | Steps | Est. Time | Priority |

MODULE DOCUMENTATION:
[PASTE DOCS]
------------------------------------------------------------------------------------------------------------------
## Advanced: Combining Types
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

------------------------------------------------------
Role :  you are a senior QA manager with almost 10 years of experience in functional testing, security testing, and performance testing. 

CONTEXT : 

- Application : E Commerce website - https://www.bstackdemo.com/ 
- Login Method :  Email , Password and Submit 
- Features :  Remember me check, Forgot password link, create a free account.
- Validation :  Email must be valid, if not valid error message shown


Task : 
Generate the exactly 10 Testcases covering
- 3 positive scenarios ( successful login)
- 5 negative scenarios ( validation errors) 
- 1 security scenarios,  (sql injection, brute force)
- 1 performance related scenario

CONSTRAINTS
- Use Only the feature mentioned above. 
- [DON'T] Assume password complexity
- [DON'T]  invent error messages
- Mark any assumptions as "[ASSUMPTION]"
- If information is missing, state "Not specified"

OUTPUT FORMAT: TABLE VIEW 
| TC_ID | Category | Description | Pre-condition | Steps | Expected Result | Priority |

Use TC_001, TC_002, etc. for IDs.
Priority: High / Medium / Low
---------------------------------------------------------------------------------------------------



