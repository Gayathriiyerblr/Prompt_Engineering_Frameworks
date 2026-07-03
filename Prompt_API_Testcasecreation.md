## Template 1: API Test Case Generation

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
-------------------------------------------------------------------------

## Template 2: REST API Test Suite

ROLE: You are an API Testing Specialist.

TASK: Generate a comprehensive test suite for this REST API endpoint.

COVERAGE AREAS:
1. Happy path (valid requests)
2. Input validation (invalid data)
3. Authentication/Authorization
4. HTTP methods (allowed vs not allowed)
5. Response validation
6. Error handling

CONSTRAINTS:
- Use ONLY the API documentation provided
- Use exact status codes from documentation
- Do NOT assume undocumented behavior
- Include request/response examples

FORMAT:
| Test ID | Category | Method | Endpoint | Request | Expected Status | Expected Response |

API DOCUMENTATION:
<<<
[PASTE API DOCS]
>>>
--------------------------------------------------------------------------

## Template 3: API Validation Tests

ROLE: You are an API QA Engineer.

TASK: Generate input validation test cases for this API endpoint.

VALIDATION SCENARIOS:
- Required fields missing
- Invalid data types
- Boundary values (min/max)
- Invalid formats (email, phone, date)
- Special characters
- Empty strings vs null

CONSTRAINTS:
- Use field constraints from API spec
- Include expected error messages if documented
- Do NOT invent validation rules

FORMAT:
| Test ID | Field | Invalid Input | Expected Error Code | Expected Message |

API SPECIFICATION:
<<<
[PASTE SPEC]
>>>
-------------------------------------------------------------------------
## Template 4: API Authentication Tests

ROLE: You are a Security-focused API Tester.

TASK: Generate authentication and authorization test cases.

SCENARIOS:
- No token/credentials
- Invalid token
- Expired token
- Wrong user permissions
- Token tampering
- Rate limiting

CONSTRAINTS:
- Use authentication method from docs
- Do NOT include actual tokens in tests
- Focus on security boundaries

FORMAT:
| Test ID | Auth Scenario | Request Setup | Expected Status | Security Validation |

AUTH DOCUMENTATION:
<<<
[PASTE AUTH DOCS]
>>>
--------------------------------------------------------------------------------

## Template 5: API Contract Testing

ROLE: You are an API Contract Testing Specialist.

TASK: Generate contract tests to validate API response structure.

VALIDATIONS:
- Response schema matches spec
- Required fields present
- Data types correct
- Nullable fields handled
- Array bounds respected

CONSTRAINTS:
- Use exact schema from documentation
- Include positive and negative cases
- Validate both success and error responses

FORMAT:
| Test ID | Response Type | Field | Expected Type | Required | Validation |

API SCHEMA:
<<<
[PASTE JSON SCHEMA OR OPENAPI SPEC]
>>>
--------------------------------------------------------------------------------------

## Template 6: API Performance Test Scenarios

ROLE: You are a Performance Test Engineer.

TASK: Design performance test scenarios for this API.

SCENARIOS:
- Baseline (single user)
- Load test (expected traffic)
- Stress test (beyond capacity)
- Spike test (sudden surge)
- Endurance test (sustained load)

CONSTRAINTS:
- Base user counts on provided metrics
- Include realistic think times
- Define clear pass/fail criteria

FORMAT:
| Scenario | Users | Duration | Ramp-up | Pass Criteria |

API METRICS:
- Expected RPS: [X]
- Target response time: [Y]ms
- Current peak users: [Z]

ENDPOINT:
<<<
[PASTE ENDPOINT INFO]
>>>
-------------------------------------------------------------------------

## Template 7: API Error Handling Tests

ROLE: You are an API QA Engineer.

TASK: Generate error handling test cases.

ERROR CATEGORIES:
- Client errors (4xx)
- Server errors (5xx)
- Timeout handling
- Malformed requests
- Service unavailable

CONSTRAINTS:
- Use error codes from documentation
- Include error response format
- Verify error messages are safe (no stack traces)

FORMAT:
| Test ID | Error Scenario | Trigger | Expected Code | Expected Response Format |

ERROR SPEC:
<<<
[PASTE ERROR DOCUMENTATION]
>>>
--------------------------------------------------------------------------------

## Generate API test cases following these examples:

EXAMPLE 1:
| TC_001 | DELETE /users/{id} | Valid user ID | 204 No Content | User deleted |

EXAMPLE 2:
| TC_002 | DELETE /users/{id} | Non-existent ID | 404 Not Found | Error message |

---

NOW GENERATE:
5 more DELETE endpoint test cases covering:
- Unauthorized access
- Invalid ID format
- Already deleted resource
- Missing authentication
- Rate limit exceeded

