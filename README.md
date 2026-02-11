# 📌 Notification Service – Low Level Design (LLD)

---

# 1️⃣ Problem Statement

Design a scalable, extensible, and plug-and-play **Notification System** that can be integrated into any application.

The system must:

- Allow creation of notification objects
- Support multiple delivery channels (Email, SMS, Popup, etc.)
- Allow dynamic modification of notification content
- Log notifications
- Maintain notification history
- Follow proper OOP and SOLID principles
- Be implemented using pure Java (no frameworks)

---

# 2️⃣ Assumptions

To clearly define the scope of this LLD problem, we assume:

1. The system runs in a single JVM process.
2. No external database is used (in-memory storage only).
3. Email/SMS sending is simulated (console output).
4. Logging is console-based.
5. Concurrency handling is out of scope (initially).
6. Notification history is stored in memory.
7. The client should not know internal implementation details.

---

# 3️⃣ Functional Requirements

1. Create a notification.
2. Dynamically modify notification content:
   - Add timestamp
   - Add signature
   - Future enhancements possible
3. Send notification via:
   - Email
   - SMS
   - Popup
   - Easily extensible for future channels
4. Log every notification.
5. Store history of all notifications.
6. Provide a simple public API:

```
sendNotification(notification)
```

---

# 4️⃣ Non-Functional Requirements

- High extensibility (Open/Closed Principle)
- Loose coupling
- Plug-and-play architecture
- Single instance of NotificationService
- Clear separation of responsibilities
- No tight coupling between:
  - Notification creation
  - Notification dispatching
  - Channel sending logic

---

![alt text](<Screenshot 2026-02-10 234143.png>)

# 5️⃣ Thought Process

When designing a notification system, we identify three major responsibilities:

## 1️⃣ Notification Creation
This is the object that contains message data.

We want:
- Different notification types
- Dynamic modification of content

This suggests:
- **Abstraction**
- **Decorator Pattern**

---

## 2️⃣ Notification Dispatching
When a notification is created, multiple components may need to react:
- Logger
- Email sender
- SMS sender
- Popup sender

This suggests:
- One-to-many relationship
- Decoupled event propagation

This clearly maps to:
- **Observer Pattern**

---

## 3️⃣ Channel-specific Sending Logic
Each channel has its own sending mechanism:
- Email logic
- SMS logic
- Popup logic

We must:
- Avoid if/else
- Avoid modifying engine for new channels
- Follow Open/Closed Principle

This suggests:
- **Strategy Pattern**

---

## 4️⃣ System Control
We do not want multiple instances managing history.

This suggests:
- **Singleton Pattern**

---

# 6️⃣ Final Architecture

```
Client
   ↓
NotificationService (Singleton)
   ↓
NotificationObservable
   ↓
Observers
   ├── LoggerObserver
   └── NotificationEngine
            ↓
        Strategies
            ├── EmailStrategy
            ├── SMSStrategy
            └── PopupStrategy
```

---

# 7️⃣ Design Patterns Used

## 1️⃣ Decorator Pattern
Used to dynamically enhance notification content.

Examples:
- TimestampDecorator
- SignatureDecorator

Benefits:
- Runtime flexibility
- Open for extension
- No modification to core class

---

## 2️⃣ Observer Pattern
Used to notify multiple listeners when a notification is pushed.

Observers:
- LoggerObserver
- NotificationEngine

Benefits:
- Loose coupling
- One-to-many dependency
- Scalable

---

## 3️⃣ Strategy Pattern
Used to separate channel-specific logic.

Strategies:
- EmailStrategy
- SMSStrategy
- PopupStrategy

Benefits:
- Open/Closed Principle
- No condition-based logic
- Easy to extend

---

## 4️⃣ Singleton Pattern
Used in NotificationService to ensure:

- Single history storage
- Centralized management
- Controlled access

---

# 8️⃣ Key Design Principles Followed

- SOLID Principles
- Single Responsibility Principle
- Open/Closed Principle
- Dependency Inversion
- Composition over Inheritance
- Separation of Concerns

---

# 9️⃣ Responsibilities Breakdown

| Component | Responsibility |
|-----------|---------------|
| INotification | Abstraction of notification |
| SimpleNotification | Base notification implementation |
| Decorators | Dynamic enhancement of content |
| IObservable | Subject abstraction |
| NotificationObservable | Maintains observers |
| IObserver | Observer abstraction |
| LoggerObserver | Logs notifications |
| NotificationEngine | Delegates to strategies |
| INotificationStrategy | Strategy abstraction |
| Concrete Strategies | Channel-specific logic |
| NotificationService | Orchestrator + History + Singleton |

---

# 🔟 Extensibility Scenarios

This design allows:

✔ Add WhatsAppStrategy without modifying existing code  
✔ Add EncryptionDecorator without modifying existing notification  
✔ Add FileLoggerObserver without touching engine  
✔ Replace console logging with file logging  
✔ Add persistence layer later  

All without breaking Open/Closed Principle.

---

# 1️⃣1️⃣ Future Improvements

- Make Singleton thread-safe
- Add async processing
- Add message queue integration
- Add database persistence
- Add retry mechanism
- Add rate limiting
- Add template engine
- Add user preference filtering
- Add priority-based dispatching

---

# 1️⃣2️⃣ Conclusion

This design demonstrates:

- Proper abstraction layering
- Clear separation of responsibilities
- Multiple pattern collaboration
- Extensible and maintainable structure
- Interview-ready LLD solution

The system is:

✔ Modular  
✔ Extensible  
✔ Decoupled  
✔ Cleanly architected  
✔ Framework-free  

---
